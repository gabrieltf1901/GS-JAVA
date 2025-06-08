package com.gestaoabrigos.controller;

import com.gestaoabrigos.dto.AbrigoDto;
import com.gestaoabrigos.service.AbrigoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/abrigos")
public class AbrigoController {

    private final AbrigoService abrigoService;

    public AbrigoController(AbrigoService abrigoService) {
        this.abrigoService = abrigoService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("abrigos", abrigoService.findAll());
        return "abrigos/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("abrigo", new AbrigoDto());
        return "abrigos/add";
    }

    @PostMapping
    public String create(@ModelAttribute("abrigo") @Valid AbrigoDto dto) {
        abrigoService.create(dto);
        return "redirect:/abrigos";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        AbrigoDto dto = abrigoService.findById(id);
        model.addAttribute("abrigo", dto);
        return "abrigos/add"; // reutiliza o mesmo formulário de add
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute("abrigo") @Valid AbrigoDto dto) {
        abrigoService.update(id, dto);
        return "redirect:/abrigos";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        abrigoService.delete(id);
        return "redirect:/abrigos";
    }
}
