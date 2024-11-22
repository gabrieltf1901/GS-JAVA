package com.sustainable.energy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "RECOMENDACAO_GS_JAVA")
public class Recomendacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataCriacao = LocalDate.now();

    @Column(nullable = false)
    private String tipoRecomendacao; // Geral ou Baseado

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Recomendacao(){}

    public Recomendacao(Long id, String descricao, LocalDate dataCriacao, String tipoRecomendacao, Usuario usuario) {
        this.id = id;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.tipoRecomendacao = tipoRecomendacao;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTipoRecomendacao() {
        return tipoRecomendacao;
    }

    public void setTipoRecomendacao(String tipoRecomendacao) {
        this.tipoRecomendacao = tipoRecomendacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
