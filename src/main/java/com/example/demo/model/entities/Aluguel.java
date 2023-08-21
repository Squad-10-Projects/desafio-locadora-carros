package com.example.demo.model.entities;


import jakarta.persistence.*;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "tb_aluguel")
public class Aluguel implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @ManyToMany
    @JoinTable(
            name = "aluguel_carro",
            joinColumns = @JoinColumn(name = "aluguel_id"),
            inverseJoinColumns = @JoinColumn(name = "carro_id")
    )

    private List<Carro> carrosSelecionados;
    private LocalDate dataPedido;
    private LocalDate dataEntrega;
    private LocalDate dataDevolucao;
    private BigDecimal valorTotal;
    private int quantidadeDias;

    @ManyToOne
    @JoinColumn(name = "motorista_id") // Nome da coluna de chave estrangeira na tabela de Aluguel
    private Motorista motorista;

    public Aluguel(LocalDate dataPedido, LocalDate dataEntrega, LocalDate dataDevolucao, BigDecimal valorTotal, int quantidadeDias){
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
        this.quantidadeDias = quantidadeDias;
    }

    public Aluguel() {

    }

    public List<Carro> getCarrosSelecionados() {
        return carrosSelecionados;
    }

    public void setCarrosSelecionados(List<Carro> carrosSelecionados) {
        this.carrosSelecionados = carrosSelecionados;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apolice_id")
    private ApoliceSeguro apoliceSeguro;

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
}

