package com.desafio.locadora.repositories;

import com.desafio.locadora.model.entities.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}