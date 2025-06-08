// UserDto.java
package com.gestaoabrigos.dto;

import jakarta.validation.constraints.*;
import java.util.Set;

/**
 * DTO para transferência de dados de User.
 */
public class UserDto {

    private Long id;

    @NotBlank(message = "Username é obrigatório")
    @Size(max = 50, message = "Username não pode exceder 50 caracteres")
    private String username;

    @NotBlank(message = "Senha é obrigatória")
    private String password;

    private Set<String> roles;

    public UserDto() {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<String> getRoles() {
        return roles;
    }
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}