package com.example.demo.model.entities;


import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

@Entity
@Table(name = "tb_aluguel")
public class Aluguel implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private LocalDate dataPedido;
    private LocalDate dataEntrega;
    private Calendar dataDevolucao;
    private BigDecimal valorTotal;
    private int quantidadeDias;

    public Aluguel(LocalDate dataPedido, LocalDate dataEntrega, Calendar dataDevolucao, BigDecimal valorTotal, int quantidadeDias){
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
        this.quantidadeDias = quantidadeDias;
    }

    public Aluguel() {

    }
    @ManyToOne
    @JoinColumn(name = "carro_id") // Nome da coluna de chave estrangeira na tabela de Aluguel
    private Carro carro;

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apolice_id")
    private ApoliceSeguro apoliceSeguro;

    @ManyToOne
    @JoinColumn(name = "pessoa_id") // Nome da coluna que faz a relação com Pessoa
    private Pessoa pessoa;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}

