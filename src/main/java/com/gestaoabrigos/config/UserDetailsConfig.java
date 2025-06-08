package com.gestaoabrigos.config;

import com.gestaoabrigos.service.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserDetailsConfig {

    private final AuthService authService;

    public UserDetailsConfig(AuthService authService) {
        this.authService = authService;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            var appUser = authService.findByUsername(username);
            var authorities = appUser.getRoles().stream()
                    .map(r -> new org.springframework.security.core.authority.SimpleGrantedAuthority(r))
                    .toList();
            return new org.springframework.security.core.userdetails.User(
                    appUser.getUsername(),
                    appUser.getPassword(),
                    authorities
            );
        };
    }
}
