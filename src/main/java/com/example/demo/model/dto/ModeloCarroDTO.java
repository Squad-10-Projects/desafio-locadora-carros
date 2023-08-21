package com.example.demo.model.dto;

import com.example.demo.model.entities.Categoria;
import com.example.demo.model.entities.ModeloCarro;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ModeloCarroDTO {

    private Long id;
    @NotBlank(message = "A descrição não pode ser vazia")
    @Size(min = 5, max = 100, message = "A descrição deve ter entre 5 e 100 caracteres")
    private String descricao;
    @NotNull(message = "A categoria não pode ser nula")
    private Categoria categoria;
    @NotNull(message = "O ID do fabricante não pode ser nulo")
    @Min(value = 1, message = "O ID do fabricante deve ser maior ou igual a 1")
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