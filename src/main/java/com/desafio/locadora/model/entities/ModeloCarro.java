package com.desafio.locadora.model.entities;

import com.desafio.locadora.model.dto.ModeloCarroDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_modelo_carro")
public class ModeloCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    public ModeloCarro() {

    }

    public ModeloCarro(Long id, String descricao, Categoria categoria, Long fabricante_id) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.fabricante = new Fabricante();
        this.fabricante.setId(fabricante_id);
    }

    public ModeloCarro(ModeloCarroDTO dto, Fabricante fabricante){
        this.id = dto.getId();
        this.descricao = dto.getDescricao();
        this.categoria = dto.getCategoria();
        this.fabricante = fabricante;
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

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) { this.fabricante = fabricante; }

}