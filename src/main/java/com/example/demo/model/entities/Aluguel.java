package com.example.demo.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "tb_aluguel")
public class Aluguel implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apolice_id")
    private ApoliceSeguro apoliceSeguro;

    private LocalDate dataPedido;
    private LocalDate dataEntrega;
    private LocalDate dataDevolucao;
    private BigDecimal valorTotal;
    private int quantidadeDias;

    public Aluguel() {

    }

    public Aluguel(LocalDate dataPedido, LocalDate dataEntrega, LocalDate dataDevolucao){
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = calcularValorTotal();
        this.quantidadeDias = calcularQuantidadeDias();
    }

    public Aluguel(LocalDate dataEntrega, LocalDate dataDevolucao, Motorista motorista, Carro carro) {
        this.carro = carro;
        this.dataPedido = LocalDate.now();
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = calcularValorTotal();
        this.quantidadeDias = calcularQuantidadeDias();
        this.motorista = motorista;
    }

    public int calcularQuantidadeDias() {
        return (int) ChronoUnit.DAYS.between(dataEntrega, dataDevolucao);
    }

    public BigDecimal calcularValorTotal() {
        int quantidadeDias = calcularQuantidadeDias();
        BigDecimal valorDiaria = carro.getValorDiaria();
        return valorDiaria.multiply(BigDecimal.valueOf(quantidadeDias));
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public ApoliceSeguro getApoliceSeguro() {
        return apoliceSeguro;
    }

    public void setApoliceSeguro(ApoliceSeguro apoliceSeguro) {
        this.apoliceSeguro = apoliceSeguro;
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

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }
}

