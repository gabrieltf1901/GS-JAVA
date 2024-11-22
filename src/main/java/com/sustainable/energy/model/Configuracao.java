package com.sustainable.energy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CONFIGURACAO_GS_JAVA")
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double tarifaEnergia;

    @Column(nullable = false)
    private Integer tempoConsumo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Configuracao(){}

    public Configuracao(Long id, Double tarifaEnergia, Integer tempoConsumo, Usuario usuario) {
        this.id = id;
        this.tarifaEnergia = tarifaEnergia;
        this.tempoConsumo = tempoConsumo;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTarifaEnergia() {
        return tarifaEnergia;
    }

    public void setTarifaEnergia(Double tarifaEnergia) {
        this.tarifaEnergia = tarifaEnergia;
    }

    public Integer getTempoConsumo() {
        return tempoConsumo;
    }

    public void setTempoConsumo(Integer tempoConsumo) {
        this.tempoConsumo = tempoConsumo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
