package com.desafio.locadora.repositories;

import com.desafio.locadora.model.entities.Acessorio;
import com.desafio.locadora.model.entities.Carro;
import com.desafio.locadora.model.entities.Categoria;
import com.desafio.locadora.model.entities.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByDisponivelTrue();
    List<Carro> findByAcessorios(Acessorio acessorio);
    List<Carro> findByModeloCarro(ModeloCarro modeloCarro);
    List<Carro> findByModeloCarroCategoria(Categoria categoria);
}
