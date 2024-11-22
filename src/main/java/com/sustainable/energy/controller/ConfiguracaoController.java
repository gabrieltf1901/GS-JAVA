package com.sustainable.energy.controller;

import com.sustainable.energy.model.Configuracao;
import com.sustainable.energy.repository.ConfiguracaoRepository;
import com.sustainable.energy.service.ConfiguracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configuracoes")
public class ConfiguracaoController {

    @Autowired
    private ConfiguracaoService configuracaoService;
    private ConfiguracaoRepository configuracaoRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Configuracao> getConfiguracaoById(@PathVariable Long id) {
        return ResponseEntity.ok(configuracaoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Configuracao> createConfiguracao(@RequestBody Configuracao configuracao) {
        return ResponseEntity.ok(configuracaoService.save(configuracao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConfiguracao(@PathVariable Long id) {
        configuracaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Configuracao>> getAllConfiguracoes(Pageable pageable) {
        Page<Configuracao> configuracoes = configuracaoRepository.findAll(pageable);
        return ResponseEntity.ok(configuracoes);
    }

}
