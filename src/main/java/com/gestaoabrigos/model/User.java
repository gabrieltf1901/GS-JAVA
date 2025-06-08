// User.java
package com.gestaoabrigos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Set;

/**
 * Entidade que representa um usuário da aplicação.
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do usuário

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank
    private String username; // Nome de usuário para login

    @Column(nullable = false)
    @NotBlank
    private String password; // Senha criptografada

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles; // Papéis (roles) do usuário

    public User() {
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