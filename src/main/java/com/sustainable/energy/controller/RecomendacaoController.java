package com.sustainable.energy.controller;

import com.sustainable.energy.model.Recomendacao;
import com.sustainable.energy.repository.RecomendacaoRepository;
import com.sustainable.energy.service.RecomendacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recomendacoes")
public class RecomendacaoController {

    @Autowired
    private RecomendacaoService recomendacaoService;
    private RecomendacaoRepository recomendacaoRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Recomendacao> getRecomendacaoById(@PathVariable Long id) {
        return ResponseEntity.ok(recomendacaoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Recomendacao> createRecomendacao(@RequestBody Recomendacao recomendacao) {
        return ResponseEntity.ok(recomendacaoService.save(recomendacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecomendacao(@PathVariable Long id) {
        recomendacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Recomendacao>> getAllRecomendacoes(Pageable pageable) {
        Page<Recomendacao> recomendacoes = recomendacaoRepository.findAll(pageable);
        return ResponseEntity.ok(recomendacoes);
    }

}

