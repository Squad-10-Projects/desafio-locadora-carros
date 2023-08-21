package com.example.demo.mappers;

import com.example.demo.model.dto.AcessorioDTO;
import com.example.demo.model.entities.Acessorio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcessorioMapper extends MapperBase<Acessorio, AcessorioDTO> {

    @Override
    AcessorioDTO modelToDTO(Acessorio entity);

    @Override
    Acessorio dtoToModel(AcessorioDTO dto);

}