package com.example.demo.repositories;

import com.example.demo.model.entities.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
}