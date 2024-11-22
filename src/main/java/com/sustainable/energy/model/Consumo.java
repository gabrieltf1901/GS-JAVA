package com.sustainable.energy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "CONSUMO_GS_JAVA")
public class Consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataHora = LocalDateTime.now();

    @Column(nullable = false)
    private Double valorConsumo;

    @ManyToOne
    @JoinColumn(name = "id_dispositivo", nullable = false)
    private Dispositivo dispositivo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Consumo(){}

    public Consumo(Long id, LocalDateTime dataHora, Double valorConsumo, Dispositivo dispositivo, Usuario usuario) {
        this.id = id;
        this.dataHora = dataHora;
        this.valorConsumo = valorConsumo;
        this.dispositivo = dispositivo;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Double getValorConsumo() {
        return valorConsumo;
    }

    public void setValorConsumo(Double valorConsumo) {
        this.valorConsumo = valorConsumo;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
