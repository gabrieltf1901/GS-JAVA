package com.sustainable.energy.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class RecomendacaoDTO {
    private Long id;

    @NotNull(message = "A descrição não pode ser nula.")
    @Size(min = 5, max = 200, message = "A descrição deve ter entre 5 e 200 caracteres.")
    private String descricao;

    private Date dataCriacao;

    @NotNull(message = "O tipo de recomendação não pode ser nulo.")
    @Pattern(regexp = "Geral|Baseado", message = "O tipo de recomendação deve ser 'Geral' ou 'Baseado'.")
    private String tipoRecomendacao;

    @NotNull(message = "O ID do usuário não pode ser nulo.")
    private Long idUsuario;

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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTipoRecomendacao() {
        return tipoRecomendacao;
    }

    public void setTipoRecomendacao(String tipoRecomendacao) {
        this.tipoRecomendacao = tipoRecomendacao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}

