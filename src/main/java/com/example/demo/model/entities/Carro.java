package com.example.demo.model.entities;

import com.example.demo.model.dto.CarroDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "tb_carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;
    private Boolean alugado;

    @ManyToOne
    @JoinColumn(name = "modelo_carro_id")
    private ModeloCarro modeloCarro;


    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_carro_acessorio",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private Set<Acessorio> acessorios = new HashSet<>();

    public Carro(List<Aluguel> alugueis) {

        this.alugueis = alugueis;
    }
    public Carro(Long id, String placa, String chassi, String cor, BigDecimal valorDiaria, ModeloCarro modeloCarro, Boolean alugado) {
        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.valorDiaria = valorDiaria;
        this.modeloCarro = modeloCarro;
        this.alugado = false;
    }

    public Carro(CarroDTO dto, ModeloCarro modeloCarro) {
        this.placa = dto.getPlaca();
        this.chassi = dto.getChassi();
        this.cor = dto.getCor();
        this.valorDiaria = dto.getValorDiaria();
        this.modeloCarro = modeloCarro;
        this.alugado = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public ModeloCarro getModeloCarro() { return modeloCarro; }

    public void setModeloCarro(ModeloCarro modeloCarro) { this.modeloCarro = modeloCarro; }

    public Set<Acessorio> getAcessorios() { return acessorios; }

    public void setAcessorios(Set<Acessorio> acessorios) { this.acessorios = acessorios; }

    public Boolean getAlugado() { return alugado; }

    public void setAlugado(Boolean alugado) { this.alugado = alugado; }
}
