package com.example.demo.repositories;

import com.example.demo.model.entities.Acessorio;
import com.example.demo.model.entities.Carro;
import com.example.demo.model.entities.Categoria;
import com.example.demo.model.entities.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByDisponivelFalse();
    List<Carro> findByAcessorios(Acessorio acessorio);
    List<Carro> findByModeloCarro(ModeloCarro modeloCarro);
    List<Carro> findByModeloCarroCategoria(Categoria categoria);
}
