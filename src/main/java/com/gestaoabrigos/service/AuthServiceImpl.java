package com.gestaoabrigos.service;

import com.gestaoabrigos.model.User;
import com.gestaoabrigos.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepo,
                           PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    private String normalize(String username) {
        return username == null ? null : username.trim().toLowerCase();
    }

    @Override
    public User login(String username, String rawPassword) {
        String normalized = normalize(username);
        User user = userRepo.findByUsernameIgnoreCase(normalized)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }
        return user;
    }

    @Override
    public User register(User user) {
        String normalized = normalize(user.getUsername());
        if (userRepo.existsByUsernameIgnoreCase(normalized)) {
            throw new RuntimeException("Usuário já existe");
        }
        user.setUsername(normalized);
        user.setRoles(Set.of("ROLE_USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        String normalized = normalize(username);
        return userRepo.findByUsernameIgnoreCase(normalized)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
