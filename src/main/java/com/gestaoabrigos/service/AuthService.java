package com.gestaoabrigos.service;

import com.gestaoabrigos.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthService {
    User login(String username, String rawPassword);
    User register(User user);
    User findByUsername(String username) throws UsernameNotFoundException;
}
