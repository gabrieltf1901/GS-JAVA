package com.gestaoabrigos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "RECURSO")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank
    private String nome;
    @Column(nullable = false, length = 30)
    @NotBlank
    @Pattern(regexp = "ALIMENTO|AGUA|COLCHAO|COBERTOR|KIT_PRIMEIROS_SOCORROS|MEDICAMENTO|OUTRO")
    private String categoria;

    @Column(name = "nivel_critico", nullable = false)
    @NotNull
    @Min(0)
    private Integer nivelCritico;

    @Column(name = "unidade_medida", nullable = false, length = 10)
    @NotBlank
    private String unidadeMedida;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();
    public Recurso() {
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
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Integer getNivelCritico() {
        return nivelCritico;
    }
    public void setNivelCritico(Integer nivelCritico) {
        this.nivelCritico = nivelCritico;
    }
    public String getUnidadeMedida() {
        return unidadeMedida;
    }
    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
