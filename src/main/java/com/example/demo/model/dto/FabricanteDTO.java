package com.example.demo.model.dto;

import com.example.demo.model.entities.Fabricante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FabricanteDTO {

    private Long id;
    @NotBlank(message = "O nome não pode estar vazio")
    @Size(max = 255, message = "O nome não pode ter mais de 255 caracteres")
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
