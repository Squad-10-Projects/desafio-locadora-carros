package com.example.demo.model.dto;

import com.example.demo.model.entities.Categoria;

public class ModeloCarroDTO {
    private Long id;
    private String descricao;
    private Categoria categoria;
    private Long fabricante;

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

    public Long getFabricante() {
        return fabricante;
    }

    public void setFabricante(Long fabricante) {
        this.fabricante = fabricante;
    }
}
