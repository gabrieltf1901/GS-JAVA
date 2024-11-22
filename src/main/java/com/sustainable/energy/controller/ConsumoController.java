package com.sustainable.energy.controller;

import com.sustainable.energy.model.Consumo;
import com.sustainable.energy.repository.ConsumoRepository;
import com.sustainable.energy.service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumos")
public class ConsumoController {

    @Autowired
    private ConsumoService consumoService;
    private ConsumoRepository consumoRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Consumo> getConsumoById(@PathVariable Long id) {
        return ResponseEntity.ok(consumoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Consumo> createConsumo(@RequestBody Consumo consumo) {
        return ResponseEntity.ok(consumoService.save(consumo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsumo(@PathVariable Long id) {
        consumoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Consumo>> getAllConsumos(Pageable pageable) {
        Page<Consumo> consumos = consumoRepository.findAll(pageable);
        return ResponseEntity.ok(consumos);
    }

}
