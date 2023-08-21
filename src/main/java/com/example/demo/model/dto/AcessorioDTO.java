package com.example.demo.model.dto;

import com.example.demo.model.entities.Acessorio;
import com.example.demo.model.entities.Carro;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AcessorioDTO {

    private Long id;
    private String descricao;
    @JsonIgnore
    private Long[] carrosId;

    public AcessorioDTO() {

    }

    public AcessorioDTO(Acessorio entity) {
        this.id = entity.getId();
        this.descricao = entity.getDescricao();
        this.carrosId = getCarrosIds(entity);
    }

    private Long[] getCarrosIds(Acessorio entity) {
        return entity.getCarros().stream()
                .map(Carro::getId)
                .toArray(Long[]::new);
    }

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

    public Long[] getCarrosId() {
        return carrosId;
    }

    public void setCarrosId(Long[] carrosId) {
        this.carrosId = carrosId;
    }
}
