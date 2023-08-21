package com.desafio.locadora.repositories;

import com.desafio.locadora.model.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    boolean existsByEmail(String email);
}
