// AbrigoDto.java
package com.gestaoabrigos.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

/**
 * DTO para transferência de dados de Abrigo.
 */
public class AbrigoDto {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome não pode exceder 100 caracteres")
    private String nome;

    @NotBlank(message = "Endereço é obrigatório")
    @Size(max = 200, message = "Endereço não pode exceder 200 caracteres")
    private String endereco;

    @NotNull(message = "Latitude é obrigatória")
    private BigDecimal latitude;

    @NotNull(message = "Longitude é obrigatória")
    private BigDecimal longitude;

    @NotNull(message = "Capacidade total é obrigatória")
    @Min(value = 1, message = "Capacidade deve ser maior que zero")
    private Integer capacidadeTotal;

    @NotBlank(message = "Status é obrigatório")
    @Pattern(regexp = "ABERTO|FECHADO", message = "Status deve ser 'ABERTO' ou 'FECHADO'")
    private String status;

    public AbrigoDto() {
    }

    // Getters e Setters
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
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public BigDecimal getLatitude() {
        return latitude;
    }
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
    public BigDecimal getLongitude() {
        return longitude;
    }
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
    public Integer getCapacidadeTotal() {
        return capacidadeTotal;
    }
    public void setCapacidadeTotal(Integer capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}