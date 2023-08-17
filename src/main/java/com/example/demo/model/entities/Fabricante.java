package com.example.demo.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_fabricante")
public class Fabricante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL)
    private List<ModeloCarro> modelosCarro = new ArrayList<>();

    public Fabricante() {

    }

    public Fabricante(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ModeloCarro> getModelosCarro() { return modelosCarro; }

    public void setModelosCarro(List<ModeloCarro> modelosCarro) { this.modelosCarro = modelosCarro; }
}