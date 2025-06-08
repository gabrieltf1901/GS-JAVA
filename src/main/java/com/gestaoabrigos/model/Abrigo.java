package com.gestaoabrigos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "ABRIGO")
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String nome;

    @Column(nullable = false, length = 200)
    @NotBlank
    private String endereco;

    @Column(nullable = false, precision = 10, scale = 7)
    @NotNull
    private BigDecimal latitude;

    @Column(nullable = false, precision = 10, scale = 7)
    @NotNull
    private BigDecimal longitude;

    @Column(name = "capacidade_total", nullable = false)
    @NotNull
    @Min(1)
    private Integer capacidadeTotal;
    @Column(nullable = false, length = 10)
    @NotBlank
    @Pattern(regexp = "ABERTO|FECHADO")
    private String status;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    public Abrigo() {
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
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}