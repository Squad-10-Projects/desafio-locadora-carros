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

    public Funcionario(Long id, String nome, String email, Date dataNascimento, String cpf, Sexo sexo, String matricula) {
        super(id, nome, email, dataNascimento, cpf, sexo);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
