package com.example.demo.model.dto;

import com.example.demo.model.entities.Acessorio;
import com.example.demo.model.entities.Carro;

import java.math.BigDecimal;

public class CarroDTO {

    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;
    private Long modeloCarroId;
    private Long[] acessoriosId;
    private Boolean disponivel;

    public CarroDTO() {

    }

    public CarroDTO(Carro entity) {
        this.id = entity.getId();
        this.placa = entity.getPlaca();
        this.chassi = entity.getChassi();
        this.cor = entity.getCor();
        this.valorDiaria = entity.getValorDiaria();
        this.modeloCarroId = entity.getModeloCarro().getId();
        this.acessoriosId = getAcessoriosIds(entity);
        this.disponivel = entity.getDisponivel();
    }

    public Long[] getAcessoriosIds(Carro entity) {
        return entity.getAcessorios().stream()
                .map(Acessorio::getId)
                .toArray(Long[]::new);
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

    public Long[] getAcessoriosId() {
        return acessoriosId;
    }

    public void setAcessoriosId(Long[] acessoriosId) {
        this.acessoriosId = acessoriosId;
    }

    public Boolean getDisponivel() { return disponivel; }

    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
}
