package com.example.demo.repositories;

import com.example.demo.model.entities.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
    boolean existsByEmail(String email);
}
