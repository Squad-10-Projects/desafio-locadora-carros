package com.desafio.locadora.services;

import com.desafio.locadora.model.entities.Acessorio;
import com.desafio.locadora.repositories.AcessorioRepository;
import com.desafio.locadora.services.exceptions.EntityNotFoundException;
import com.desafio.locadora.mappers.AcessorioMapper;
import com.desafio.locadora.model.dto.AcessorioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository repository;
    @Autowired
    private AcessorioMapper mapper;

    @Transactional(readOnly = true)
    public List<AcessorioDTO> obterTodos() {
        List<Acessorio> acessorios = this.repository.findAll();
        return acessorios.stream().map(this.mapper::modelToDTO).toList();
    }

    @Transactional(readOnly = true)
    public AcessorioDTO obterPorId(Long id) {
        return this.mapper.modelToDTO(this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Acessório não encontrado")));
    }

    public AcessorioDTO salvar(AcessorioDTO dto) {
        Acessorio acessorio = mapper.dtoToModel(dto);
        acessorio = repository.save(acessorio);
        return mapper.modelToDTO(acessorio);
    }

    public AcessorioDTO atualizar(Long id, AcessorioDTO acessorioDTO) {
        Acessorio acessorio = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Acessório não encontrado"));
        Acessorio acessorioAtualizado = mapper.dtoToModel(acessorioDTO);
        acessorioAtualizado.setId(acessorio.getId());
        acessorioAtualizado = repository.save(acessorioAtualizado);
        return mapper.modelToDTO(acessorioAtualizado);
    }

    public void deletarPorId(Long id) {
        Acessorio acessorio = repository.findById(id) .orElseThrow(() -> new EntityNotFoundException("Acessório não encontrado"));
        repository.delete(acessorio);
    }
}
