package com.sustainable.energy.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.security.Timestamp;

public class ConsumoDTO {
    private Long id;

    private Timestamp dataHora;

    @NotNull(message = "O valor do consumo não pode ser nulo.")
    @Positive(message = "O valor do consumo deve ser um número positivo.")
    private Double valorConsumo;

    @NotNull(message = "O ID do dispositivo não pode ser nulo.")
    private Long idDispositivo;

    @NotNull(message = "O ID do usuário não pode ser nulo.")
    private Long idUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public Double getValorConsumo() {
        return valorConsumo;
    }

    public void setValorConsumo(Double valorConsumo) {
        this.valorConsumo = valorConsumo;
    }

    public Long getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Long idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
