package com.example.demo.services;

import com.example.demo.mappers.InformacoesPagamentoMapper;
import com.example.demo.model.dto.InformacoesPagamentoDTO;
import com.example.demo.model.entities.InformacoesPagamento;
import com.example.demo.repositories.InformacoesPagamentoRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InformacoesPagamentoService {

    @Autowired
    private InformacoesPagamentoRepository repository;
    @Autowired
    private InformacoesPagamentoMapper mapper;

    @Transactional(readOnly = true)
    public List<InformacoesPagamentoDTO> obterTodos() {
        List<InformacoesPagamento> informacoesPagamentoList = this.repository.findAll();
        return informacoesPagamentoList.stream().map(this.mapper::modelToDTO).toList();
    }

    @Transactional(readOnly = true)
    public InformacoesPagamentoDTO obterPorId(Long id) {
        return this.mapper.modelToDTO(this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Informações de pagamento não encontradas")));
    }

    public InformacoesPagamentoDTO criarInformacoesPagamento(InformacoesPagamentoDTO informacoesPagamentoDTO) {
        InformacoesPagamento informacoesPagamento = mapper.dtoToModel(informacoesPagamentoDTO);
        informacoesPagamento = repository.save(informacoesPagamento);
        return mapper.modelToDTO(informacoesPagamento);
    }

    public InformacoesPagamento obterInformacoesPagamento(Long informacoesPagamentoId) {
        return repository.findById(informacoesPagamentoId).orElseThrow(() -> new EntityNotFoundException("Informações de pagamento não encontradas"));
    }

    public InformacoesPagamentoDTO atualizarInformacoesPagamento(Long id, InformacoesPagamentoDTO informacoesPagamentoDTO) {
        InformacoesPagamento informacoesPagamento = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Informações de pagamento não encontradas"));
        InformacoesPagamento informacoesPagamentoAtualizado = mapper.dtoToModel(informacoesPagamentoDTO);
        informacoesPagamentoAtualizado.setId(informacoesPagamento.getId());
        informacoesPagamentoAtualizado = repository.save(informacoesPagamentoAtualizado);
        return mapper.modelToDTO(informacoesPagamentoAtualizado);
    }

    public void deletarInformacoesPagamento(Long id) {
        InformacoesPagamento informacoesPagamento = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Informações de pagamento não encontradas"));
        repository.delete(informacoesPagamento);
    }
}

