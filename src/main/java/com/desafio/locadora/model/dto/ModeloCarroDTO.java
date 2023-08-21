package com.desafio.locadora.model.dto;

import com.desafio.locadora.model.entities.Categoria;
import com.desafio.locadora.model.entities.ModeloCarro;

public class ModeloCarroDTO {

    private Long id;
    private String descricao;
    private Categoria categoria;
    private Long fabricanteId;
    public ModeloCarroDTO() {

    }

    public ModeloCarroDTO(ModeloCarro entity) {
        this.id = entity.getId();
        this.descricao = entity.getDescricao();
        this.categoria = entity.getCategoria();
        this.fabricanteId = entity.getFabricante().getId();
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getFabricanteId() { return fabricanteId; }

    public void setFabricanteId(Long fabricanteId) { this.fabricanteId = fabricanteId; }
}