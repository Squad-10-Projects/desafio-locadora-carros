package com.example.demo.services;

import com.example.demo.model.entities.Carro;
import com.example.demo.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public List<Carro> findAll() {
        return repository.findAll();
    }
}
