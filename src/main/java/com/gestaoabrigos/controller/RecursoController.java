package com.gestaoabrigos.controller;

import com.gestaoabrigos.dto.RecursoDto;
import com.gestaoabrigos.model.CategoriaRecurso;
import com.gestaoabrigos.service.RecursoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/recursos")
public class RecursoController {

    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping
    public String list(Model model) {
        List<RecursoDto> recursos = recursoService.findAll();
        model.addAttribute("recursos", recursos);
        return "recursos/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("recurso", new RecursoDto());
        return "recursos/add";
    }

    @PostMapping
    public String create(@ModelAttribute("recurso") @Valid RecursoDto dto) {
        recursoService.create(dto);
        return "redirect:/recursos";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        RecursoDto dto = recursoService.findById(id);
        model.addAttribute("recurso", dto);
        return "recursos/add";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("recurso") @Valid RecursoDto dto) {
        recursoService.update(id, dto);
        return "redirect:/recursos";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        recursoService.delete(id);
        return "redirect:/recursos";
    }

    @ModelAttribute("todasCategorias")
    public CategoriaRecurso[] todasCategorias() {
        return CategoriaRecurso.values();
    }
}
