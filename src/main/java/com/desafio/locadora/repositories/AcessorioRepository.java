package com.desafio.locadora.repositories;

import com.desafio.locadora.model.entities.Acessorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {

}
