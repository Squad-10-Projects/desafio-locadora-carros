package com.example.demo.model.dto;

import com.example.demo.model.entities.Acessorio;

public class AcessorioDTO {

    private Long id;
    private String descricao;

    public AcessorioDTO() {

    }

    public AcessorioDTO(Acessorio entity) {
        this.id = entity.getId();
        this.descricao = entity.getDescricao();
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

}
