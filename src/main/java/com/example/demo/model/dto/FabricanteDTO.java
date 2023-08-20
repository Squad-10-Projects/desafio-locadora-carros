package com.example.demo.model.dto;

import com.example.demo.model.entities.Fabricante;

public class FabricanteDTO {

    private Long id;
    private String nome;

    public FabricanteDTO() {

    }

    public FabricanteDTO(Fabricante entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

}
