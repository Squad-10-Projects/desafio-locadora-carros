package com.example.demo.model.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario extends Pessoa {

    private String matricula;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, Date dataNascimento, String cpf, String matricula) {
        super(id, nome, dataNascimento, cpf);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
