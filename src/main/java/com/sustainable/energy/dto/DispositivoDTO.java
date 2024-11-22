package com.sustainable.energy.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class DispositivoDTO {
    private Long id;

    @NotNull(message = "O nome do dispositivo não pode ser nulo.")
    @Size(min = 3, max = 100, message = "O nome do dispositivo deve ter entre 3 e 100 caracteres.")
    private String nome;

    @NotNull(message = "O tipo do dispositivo não pode ser nulo.")
    @Pattern(regexp = "Real|Simulado", message = "O tipo deve ser 'Real' ou 'Simulado'.")
    private String tipo;

    @NotNull(message = "A potência não pode ser nula.")
    @Positive(message = "A potência deve ser um número positivo.")
    private Double potencia;

    @NotNull(message = "O status do dispositivo não pode ser nulo.")
    @Pattern(regexp = "Ativo|Inativo", message = "O status deve ser 'Ativo' ou 'Inativo'.")
    private String status;

    @NotNull(message = "O ID do usuário não pode ser nulo.")
    private Long idUsuario;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}

