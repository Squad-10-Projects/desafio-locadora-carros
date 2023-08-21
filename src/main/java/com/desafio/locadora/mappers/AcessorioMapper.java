package com.desafio.locadora.mappers;

import com.desafio.locadora.model.dto.AcessorioDTO;
import com.desafio.locadora.model.entities.Acessorio;
import com.desafio.locadora.model.entities.Carro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AcessorioMapper extends MapperBase<Acessorio, AcessorioDTO> {

    @Override
    AcessorioDTO modelToDTO(Acessorio entity);

    @Override
    Acessorio dtoToModel(AcessorioDTO dto);

}