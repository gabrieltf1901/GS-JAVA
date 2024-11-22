package com.sustainable.energy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "DISPOSITIVO_GS_JAVA")
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String tipo; // Real ou Simulado

    private Double potencia;

    @NotBlank
    @Column(nullable = false)
    private String status; // Ativo ou Inativo

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Dispositivo(){}

    public Dispositivo(Long id, String nome, String tipo, Double potencia, String status, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.potencia = potencia;
        this.status = status;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
