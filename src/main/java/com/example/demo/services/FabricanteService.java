package com.example.demo.services;

import com.example.demo.model.entities.Fabricante;
import com.example.demo.repositories.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository repository;

    public List<Fabricante> findAll() {
        return repository.findAll();
    }
}