package com.example.demo.services;

import com.example.demo.model.entities.Acessorio;
import com.example.demo.model.entities.Carro;
import com.example.demo.repositories.AcessorioRepository;
import com.example.demo.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository repository;

    @Transactional(readOnly = true)
    public List<Acessorio> findAll() {
        return repository.findAll();
    }
}
