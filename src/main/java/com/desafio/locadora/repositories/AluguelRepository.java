package com.desafio.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.desafio.locadora.model.entities.Aluguel;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    List<Aluguel> findByMotoristaIdAndDataDevolucaoAfter(Long motoristaId, LocalDate dataDevolucao);
}
