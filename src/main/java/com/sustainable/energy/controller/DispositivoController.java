package com.sustainable.energy.controller;

import com.sustainable.energy.model.Dispositivo;
import com.sustainable.energy.repository.DispositivoRepository;
import com.sustainable.energy.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dispositivos")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;
    private DispositivoRepository dispositivoRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> getDispositivoById(@PathVariable Long id) {
        return ResponseEntity.ok(dispositivoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Dispositivo> createDispositivo(@RequestBody Dispositivo dispositivo) {
        return ResponseEntity.ok(dispositivoService.save(dispositivo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable Long id) {
        dispositivoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Dispositivo>> getAllDispositivos(Pageable pageable) {
        Page<Dispositivo> dispositivos = dispositivoRepository.findAll(pageable);
        return ResponseEntity.ok(dispositivos);
    }

}
