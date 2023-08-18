package com.example.demo.services;

import com.example.demo.model.entities.Fabricante;
import com.example.demo.repositories.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public List<Fabricante> findAll() {
        return fabricanteRepository.findAll();
    }

    public Fabricante create(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }

    public Optional<Fabricante> findById(Long id) {
        return fabricanteRepository.findById(id);
    }

    public Fabricante update(Long id, Fabricante fabricante) {
        Optional<Fabricante> existingFabricante = fabricanteRepository.findById(id);

        if (existingFabricante.isPresent()) {
            fabricante.setId(id);
            return fabricanteRepository.save(fabricante);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        fabricanteRepository.deleteById(id);
    }
}