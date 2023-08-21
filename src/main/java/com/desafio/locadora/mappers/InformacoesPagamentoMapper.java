package com.desafio.locadora.mappers;

import com.desafio.locadora.model.dto.InformacoesPagamentoDTO;
import com.desafio.locadora.model.entities.InformacoesPagamento;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface InformacoesPagamentoMapper extends MapperBase<InformacoesPagamento, InformacoesPagamentoDTO> {
    @Override
    InformacoesPagamentoDTO modelToDTO(InformacoesPagamento entity);

    @Override
    InformacoesPagamento dtoToModel(InformacoesPagamentoDTO dto);
}
