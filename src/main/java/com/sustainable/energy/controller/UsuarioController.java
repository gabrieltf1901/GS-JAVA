package com.sustainable.energy.controller;


import com.sustainable.energy.model.Usuario;
import com.sustainable.energy.repository.UsuarioRepository;
import com.sustainable.energy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> getAllUsuarios(Pageable pageable) {
        Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
        return ResponseEntity.ok(usuarios);
    }
}
