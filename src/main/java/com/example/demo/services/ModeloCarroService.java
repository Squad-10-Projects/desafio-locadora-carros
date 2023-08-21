package com.example.demo.services;

import com.example.demo.repositories.FabricanteRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;
import com.example.demo.mappers.ModeloCarroMapper;
import com.example.demo.model.dto.ModeloCarroDTO;
import com.example.demo.model.entities.Fabricante;
import com.example.demo.model.entities.ModeloCarro;
import com.example.demo.repositories.ModeloCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ModeloCarroService {

    @Autowired
    private ModeloCarroRepository repository;
    @Autowired
    private ModeloCarroMapper mapper;
    @Autowired
    private FabricanteRepository fabricanteRepository;


    @Transactional(readOnly = true)
    public List<ModeloCarroDTO> obterTodos() {
        List<ModeloCarro> modelos = this.repository.findAll();
        return modelos.stream().map(this.mapper::modelToDTO).toList();
    }

    @Transactional(readOnly = true)
    public ModeloCarroDTO obterPorId(Long id) {
        return this.mapper.modelToDTO(this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado")));
    }

    public ModeloCarroDTO salvar(ModeloCarroDTO dto) {
        Fabricante fabricante = fabricanteRepository.findById(dto.getFabricanteId())
                .orElseThrow(() -> new EntityNotFoundException("Fabricante não encontrado"));

        ModeloCarro modelo = new ModeloCarro(dto, fabricante);
        modelo = repository.save(modelo);
        return mapper.modelToDTO(modelo);
    }

    public ModeloCarroDTO atualizar(Long id, ModeloCarroDTO modeloDTO) {
        ModeloCarro modelo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));
        ModeloCarro modeloAtualizado = mapper.dtoToModel(modeloDTO);
        modeloAtualizado.setId(modelo.getId());
        modeloAtualizado = repository.save(modeloAtualizado);
        return mapper.modelToDTO(modeloAtualizado);
    }

    public void deletarPorId(Long id) {
        ModeloCarro modelo = repository.findById(id) .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));
        repository.delete(modelo);
    }
}