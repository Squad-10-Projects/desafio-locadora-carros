package com.example.demo.model.entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_motorista")
public class Motorista extends Pessoa {

    private String numeroCNH;

    public Motorista() {
    }

    public Motorista(Long id, String nome, String email, Date dataNascimento, String cpf, Sexo sexo, String numeroCNH) {
        super(id, nome, email, dataNascimento, cpf, sexo);
        this.numeroCNH = numeroCNH;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }
}
