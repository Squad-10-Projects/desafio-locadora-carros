package com.example.demo.mappers;


import com.example.demo.model.dto.InformacoesPagamentoDTO;
import com.example.demo.model.entities.InformacoesPagamento;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface InformacoesPagamentoMapper extends MapperBase<InformacoesPagamento, InformacoesPagamentoDTO> {
    @Override
    InformacoesPagamentoDTO modelToDTO(InformacoesPagamento entity);

    @Override
    InformacoesPagamento dtoToModel(InformacoesPagamentoDTO dto);
}
