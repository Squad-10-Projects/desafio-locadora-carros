package com.example.demo.services;

import com.example.demo.mappers.ApoliceSeguroMapper;
import com.example.demo.model.dto.ApoliceSeguroDTO;
import com.example.demo.model.entities.Aluguel;
import com.example.demo.model.entities.ApoliceSeguro;
import com.example.demo.repositories.AluguelRepository;
import com.example.demo.repositories.ApoliceSeguroRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
@Validated
public class ApoliceSeguroService {

    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private ApoliceSeguroRepository repository;
    @Autowired
    private ApoliceSeguroMapper mapper;

    @Transactional(readOnly = true)
    public List<ApoliceSeguroDTO> obterTodos() {
        List<ApoliceSeguro> apolices = this.repository.findAll();
        return apolices.stream().map(this.mapper::modelToDTO).toList();
    }

    @Transactional(readOnly = true)
    public ApoliceSeguroDTO obterPorId(Long id) {
        return this.mapper.modelToDTO(this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Apólice de seguro não encontrada")));
    }

    public ApoliceSeguroDTO salvar(@Valid ApoliceSeguroDTO dto, Long aluguelId) {
        Aluguel aluguel = aluguelRepository.findById(aluguelId)
                .orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado"));
        ApoliceSeguro apolice = mapper.dtoToModel(dto);
        apolice.setAluguel(aluguel);
        aluguel.setApoliceSeguro(apolice);
        apolice = repository.save(apolice);
        return mapper.modelToDTO(apolice);
    }

    public ApoliceSeguroDTO atualizar(Long id, @Valid ApoliceSeguroDTO apoliceDTO) {
        ApoliceSeguro apolice = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Apólice de seguro não encontrada"));
        ApoliceSeguro apoliceAtualizada = mapper.dtoToModel(apoliceDTO);
        apoliceAtualizada.setId(apolice.getId());
        apoliceAtualizada = repository.save(apoliceAtualizada);
        return mapper.modelToDTO(apoliceAtualizada);
    }

    public void deletarPorId(Long id) {
        ApoliceSeguro apolice = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Apólice de seguro não encontrada"));
        repository.delete(apolice);
    }
}