package com.example.demo.mappers;

import com.example.demo.model.dto.InformacoesPagamentoDTO;
import com.example.demo.model.entities.InformacoesPagamento;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-21T02:31:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class InformacoesPagamentoMapperImpl implements InformacoesPagamentoMapper {

    @Override
    public List<InformacoesPagamentoDTO> listModelToListDto(List<InformacoesPagamento> all) {
        if ( all == null ) {
            return null;
        }

        List<InformacoesPagamentoDTO> list = new ArrayList<InformacoesPagamentoDTO>( all.size() );
        for ( InformacoesPagamento informacoesPagamento : all ) {
            list.add( modelToDTO( informacoesPagamento ) );
        }

        return list;
    }

    @Override
    public InformacoesPagamentoDTO modelToDTO(InformacoesPagamento entity) {
        if ( entity == null ) {
            return null;
        }

        InformacoesPagamentoDTO informacoesPagamentoDTO = new InformacoesPagamentoDTO();

        if ( entity.getId() != null ) {
            informacoesPagamentoDTO.setId( entity.getId() );
        }
        if ( entity.getNumeroCartao() != null ) {
            informacoesPagamentoDTO.setNumeroCartao( entity.getNumeroCartao() );
        }
        if ( entity.getDataExpiracao() != null ) {
            informacoesPagamentoDTO.setDataExpiracao( entity.getDataExpiracao() );
        }
        informacoesPagamentoDTO.setCvv( entity.getCvv() );

        return informacoesPagamentoDTO;
    }

    @Override
    public InformacoesPagamento dtoToModel(InformacoesPagamentoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        InformacoesPagamento informacoesPagamento = new InformacoesPagamento();

        if ( dto.getId() != null ) {
            informacoesPagamento.setId( dto.getId() );
        }
        if ( dto.getNumeroCartao() != null ) {
            informacoesPagamento.setNumeroCartao( dto.getNumeroCartao() );
        }
        if ( dto.getDataExpiracao() != null ) {
            informacoesPagamento.setDataExpiracao( dto.getDataExpiracao() );
        }
        informacoesPagamento.setCvv( dto.getCvv() );

        return informacoesPagamento;
    }
}
