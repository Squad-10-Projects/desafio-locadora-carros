package com.example.demo.services;

import com.example.demo.model.entities.ModeloCarro;
import com.example.demo.repositories.ModeloCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloCarroService {

    @Autowired
    private ModeloCarroRepository repository;

    public List<ModeloCarro> findAll() {
        return repository.findAll();
    }
}