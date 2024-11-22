package com.sustainable.energy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "USUARIO_GS_JAVA")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    private String senha;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @NotBlank
    @Column(name = "tipo_usuario", nullable = false)
    private String tipoUsuario;

    public Usuario(){}

    public Usuario(Long id, String nome, String email, String senha, LocalDateTime dataCadastro, String tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.tipoUsuario = tipoUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
