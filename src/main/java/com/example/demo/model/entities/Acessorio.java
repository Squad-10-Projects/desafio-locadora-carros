package com.example.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_acessorio")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @JsonBackReference
    @ManyToMany(mappedBy = "acessorios", fetch = FetchType.EAGER)
    private Set<Carro> carros = new HashSet<>();

    public Acessorio(){

    }

    public Acessorio(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Set<Carro> getCarros() { return carros; }

    public void setCarros(Set<Carro> carros) { this.carros = carros; }
}
