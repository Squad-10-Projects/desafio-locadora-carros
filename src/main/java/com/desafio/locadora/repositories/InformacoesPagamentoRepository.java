package com.desafio.locadora.repositories;

import com.desafio.locadora.model.entities.InformacoesPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacoesPagamentoRepository extends JpaRepository<InformacoesPagamento, Long> {
}
