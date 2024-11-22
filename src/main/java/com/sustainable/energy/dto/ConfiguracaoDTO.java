package com.sustainable.energy.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ConfiguracaoDTO {
    private Long id;

    @NotNull(message = "A tarifa de energia não pode ser nula.")
    @Positive(message = "A tarifa de energia deve ser um número positivo.")
    private Double tarifaEnergia;

    @NotNull(message = "O tempo de consumo não pode ser nulo.")
    @Positive(message = "O tempo de consumo deve ser um número positivo.")
    private Double tempoConsumo;

    @NotNull(message = "O ID do usuário não pode ser nulo.")
    private Long idUsuario;

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

    public Double getTempoConsumo() {
        return tempoConsumo;
    }

    public void setTempoConsumo(Double tempoConsumo) {
        this.tempoConsumo = tempoConsumo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}

