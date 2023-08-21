package com.desafio.locadora.services;

import com.desafio.locadora.services.exceptions.EntityNotFoundException;
import com.desafio.locadora.mappers.FabricanteMapper;
import com.desafio.locadora.model.dto.FabricanteDTO;
import com.desafio.locadora.model.entities.Fabricante;
import com.desafio.locadora.repositories.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FabricanteService {

    @Autowired
    private FabricanteRepository repository;
    @Autowired
    private FabricanteMapper mapper;

    @Transactional(readOnly = true)
    public List<FabricanteDTO> obterTodos() {
        List<Fabricante> fabricantes = this.repository.findAll();
        return fabricantes.stream().map(this.mapper::modelToDTO).toList();
    }

    @Transactional(readOnly = true)
    public FabricanteDTO obterPorId(Long id) {
        return this.mapper.modelToDTO(this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fabricante não encontrado")));
    }

    public FabricanteDTO salvar(FabricanteDTO dto) {
        Fabricante fabricante = mapper.dtoToModel(dto);
        fabricante = repository.save(fabricante);
        return mapper.modelToDTO(fabricante);
    }

    public FabricanteDTO atualizar(Long id, FabricanteDTO fabricanteDTO) {
        Fabricante fabricante = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));
        Fabricante fabricanteAtualizado = mapper.dtoToModel(fabricanteDTO);
        fabricanteAtualizado.setId(fabricante.getId());
        fabricanteAtualizado = repository.save(fabricanteAtualizado);
        return mapper.modelToDTO(fabricanteAtualizado);
    }

    public void deletarPorId(Long id) {
        Fabricante fabricante = repository.findById(id) .orElseThrow(() -> new EntityNotFoundException("Fabricante não encontrado"));
        repository.delete(fabricante);
    }
}