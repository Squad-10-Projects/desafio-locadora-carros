package com.example.demo.repositories;

import com.example.demo.model.entities.Acessorio;
import com.example.demo.model.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {

}
