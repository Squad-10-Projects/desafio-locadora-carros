package com.example.demo.model.dto;

import com.example.demo.model.entities.ApoliceSeguro;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class ApoliceSeguroDTO {

    private Long id;

    @NotNull(message = "O valor da franquia não pode ser nulo")
    @Positive(message = "O valor da franquia deve ser positivo")
    @DecimalMin(value = "0.01", message = "O valor da franquia deve ser maior ou igual a 0.01")
    private BigDecimal valorFranquia;
    private boolean protecaoTerceiro;
    private boolean protecaoCausasNaturais;
    private boolean protecaoRoubo;

    public ApoliceSeguroDTO() {

    }

    public ApoliceSeguroDTO(ApoliceSeguro entity) {
        this.id = entity.getId();
        this.valorFranquia = entity.getValorFranquia();
        this.protecaoTerceiro = entity.isProtecaoTerceiro();
        this.protecaoCausasNaturais = entity.isProtecaoCausasNaturais();
        this.protecaoRoubo = entity.isProtecaoRoubo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorFranquia() {
        return valorFranquia;
    }

    public void setValorFranquia(BigDecimal valorFranquia) {
        this.valorFranquia = valorFranquia;
    }

    public boolean isProtecaoTerceiro() {
        return protecaoTerceiro;
    }

    public void setProtecaoTerceiro(boolean protecaoTerceiro) {
        this.protecaoTerceiro = protecaoTerceiro;
    }

    public boolean isProtecaoCausasNaturais() {
        return protecaoCausasNaturais;
    }

    public void setProtecaoCausasNaturais(boolean protecaoCausasNaturais) {
        this.protecaoCausasNaturais = protecaoCausasNaturais;
    }

    public boolean isProtecaoRoubo() {
        return protecaoRoubo;
    }

    public void setProtecaoRoubo(boolean protecaoRoubo) {
        this.protecaoRoubo = protecaoRoubo;
    }
}