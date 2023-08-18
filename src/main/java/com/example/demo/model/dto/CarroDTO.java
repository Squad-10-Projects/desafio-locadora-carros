package com.example.demo.model.dto;

import com.example.demo.model.entities.Acessorio;
import com.example.demo.model.entities.Carro;
import com.example.demo.model.entities.ModeloCarro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class CarroDTO implements Serializable {

    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;
    private ModeloCarro modeloCarro;
    private Set<Acessorio> acessorios = new HashSet<>();

    public CarroDTO(){

    }
    public CarroDTO(Carro entity) {
        this.id = entity.getId();
        this.placa = entity.getPlaca();
        this.chassi = entity.getChassi();
        this.cor = entity.getCor();
        this.valorDiaria = entity.getValorDiaria();
        this.modeloCarro = entity.getModeloCarro();
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

    public ModeloCarro getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(ModeloCarro modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public Set<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(Set<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
}
