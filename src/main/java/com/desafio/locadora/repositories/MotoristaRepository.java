package com.desafio.locadora.repositories;

import com.desafio.locadora.model.entities.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
    boolean existsByEmail(String email);
}
