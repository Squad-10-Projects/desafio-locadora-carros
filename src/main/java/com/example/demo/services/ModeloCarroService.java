package com.example.demo.services;

import com.example.demo.model.dto.ModeloCarroDTO;
import com.example.demo.model.entities.ModeloCarro;
import com.example.demo.repositories.ModeloCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloCarroService {

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    public List<ModeloCarro> findAll() {
        return modeloCarroRepository.findAll();
    }

    public ModeloCarro create(ModeloCarro modeloCarro) {

        return modeloCarroRepository.save(modeloCarro);
    }

    public Optional<ModeloCarro> findById(Long id) {
        return modeloCarroRepository.findById(id);
    }

    public ModeloCarro update(Long id, ModeloCarro modeloCarro) {
        Optional<ModeloCarro> existingModeloCarro = modeloCarroRepository.findById(id);

        if (existingModeloCarro.isPresent()) {
            modeloCarro.setId(id);
            return modeloCarroRepository.save(modeloCarro);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        modeloCarroRepository.deleteById(id);
    }

    public ModeloCarroDTO toDTO(ModeloCarro modeloCarro) {
        ModeloCarroDTO dto = new ModeloCarroDTO();
        dto.setId(modeloCarro.getId());
        dto.setDescricao(modeloCarro.getDescricao());
        dto.setCategoria(modeloCarro.getCategoria());
        dto.setFabricante(modeloCarro.getFabricante().getId());
        return dto;
    }
}