package com.example.demo.repositories;

import com.example.demo.model.entities.InformacoesPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacoesPagamentoRepository extends JpaRepository<InformacoesPagamento, Long> {
}
