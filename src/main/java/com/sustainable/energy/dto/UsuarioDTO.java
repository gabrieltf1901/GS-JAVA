package com.sustainable.energy.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class UsuarioDTO {
    private Long id;

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    @NotNull(message = "O email não pode ser nulo.")
    @Email(message = "Formato de email inválido.")
    private String email;

    @NotNull(message = "A senha não pode ser nula.")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
    private String senha;

    @NotNull(message = "O tipo de usuário não pode ser nulo.")
    private String tipoUsuario;

    private Date dataCadastro;

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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}

