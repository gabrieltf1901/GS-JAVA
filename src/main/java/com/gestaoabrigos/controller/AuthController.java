package com.gestaoabrigos.controller;

import com.gestaoabrigos.model.User;
import com.gestaoabrigos.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Processa o envio do formulário de registro
    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute("user") @Valid User user,
            BindingResult bindingResult,
            RedirectAttributes redirectAttrs
    ) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        authService.register(user);

        redirectAttrs.addFlashAttribute("success", "Cadastro realizado com sucesso! Faça login abaixo.");
        return "redirect:/login";
    }

}
