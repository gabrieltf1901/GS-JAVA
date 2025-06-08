package com.gestaoabrigos.dto;

import jakarta.validation.constraints.*;


public class RecursoDto {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 50, message = "Nome não pode exceder 50 caracteres")
    private String nome;

    @NotBlank(message = "Categoria é obrigatória")
    @Pattern(
            regexp = "ALIMENTO|AGUA|COLCHAO|COBERTOR|KIT_PRIMEIROS_SOCORROS|MEDICAMENTO|OUTRO",
            message = "Categoria inválida"
    )
    private String categoria;

    @NotNull(message = "Nível crítico é obrigatório")
    @Min(value = 0, message = "Nível crítico não pode ser negativo")
    private Integer nivelCritico;

    @NotBlank(message = "Unidade de medida é obrigatória")
    @Size(max = 10, message = "Unidade de medida não pode exceder 10 caracteres")
    private String unidadeMedida;

    public RecursoDto() {
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
}
