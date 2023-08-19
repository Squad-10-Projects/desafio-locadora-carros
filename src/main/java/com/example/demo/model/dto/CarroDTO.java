package com.example.demo.model.dto;

import com.example.demo.model.entities.Acessorio;
import com.example.demo.model.entities.Carro;
import com.example.demo.model.entities.ModeloCarro;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class CarroDTO {

    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;
    private Long modeloCarroId;
    private Long[] acessoriosIds;

    public CarroDTO() {

    }

    public CarroDTO(Carro entity) {
        this.id = entity.getId();
        this.placa = entity.getPlaca();
        this.chassi = entity.getChassi();
        this.cor = entity.getCor();
        this.valorDiaria = entity.getValorDiaria();
        this.modeloCarroId = entity.getModeloCarro().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Long getModeloCarroId() { return modeloCarroId; }

    public void setModeloCarroId(Long modeloCarroId) { this.modeloCarroId = modeloCarroId; }

    public Long[] getAcessoriosIds() {
        return acessoriosIds;
    }

    public void setAcessoriosIds(Long[] acessoriosIds) {
        this.acessoriosIds = acessoriosIds;
    }
}
