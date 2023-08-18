package com.example.demo.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="tb_apolice")
public class ApoliceSeguro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal valorFranquia;
    private boolean protecaoTerceiro;
    private boolean protecaoCausasNaturais;
    private boolean protecaoRoubo;


    @OneToOne(mappedBy = "apoliceSeguro")
    private Aluguel aluguel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getValorFranquia() {
        return valorFranquia;
    }

    public void setValorFranquia(BigDecimal valorFranquia) {
        this.valorFranquia = valorFranquia;
    }

    public boolean isProtecaoTerceiro() {
        return protecaoTerceiro;
    }

    public void setProtecaoTerceiro(boolean protecaoTerceiro) {
        this.protecaoTerceiro = protecaoTerceiro;
    }

    public boolean isProtecaoCausasNaturais() {
        return protecaoCausasNaturais;
    }

    public void setProtecaoCausasNaturais(boolean protecaoCausasNaturais) {
        this.protecaoCausasNaturais = protecaoCausasNaturais;
    }

    public boolean isProtecaoRoubo() {
        return protecaoRoubo;
    }

    public void setProtecaoRoubo(boolean protecaoRoubo) {
        this.protecaoRoubo = protecaoRoubo;
    }
}
