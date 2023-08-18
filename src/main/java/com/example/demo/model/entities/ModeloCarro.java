package com.example.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_modelo_carro")
public class ModeloCarro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private Categoria categoria;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    @OneToMany(mappedBy = "modeloCarro", cascade = CascadeType.ALL)
    private List<Carro> carros = new ArrayList<>();

    public ModeloCarro() {

    }

    public ModeloCarro(Long id, String descricao, Categoria categoria, Fabricante fabricante) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
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

    public Fabricante getFabricante() { return fabricante; }

    public void setFabricante(Fabricante fabricante) { this.fabricante = fabricante; }

    public List<Carro> getCarros() { return carros; }

    public void setCarros(List<Carro> carros) { this.carros = carros; }
}