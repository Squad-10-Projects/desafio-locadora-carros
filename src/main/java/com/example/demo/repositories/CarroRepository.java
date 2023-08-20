package com.example.demo.repositories;

import com.example.demo.model.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByAlugadoFalse();
}
