package com.example.demo.services;

import com.example.demo.model.entities.Carro;
import com.example.demo.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    @Transactional(readOnly = true)
    public List<Carro> findAll() {
        return repository.findAll();
    }
}
