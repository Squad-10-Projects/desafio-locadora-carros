package com.example.demo.model.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "tb_motorista")
public class Motorista extends Pessoa {

    private String numeroCNH;

    public Motorista() {
    }

    public Motorista(Long id, String nome, Date dataNascimento, String cpf, String numeroCNH) {
        super(id, nome, dataNascimento, cpf);
        this.numeroCNH = numeroCNH;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }
}
