package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.entities.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

}
