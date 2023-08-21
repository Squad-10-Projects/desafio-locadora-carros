package com.example.demo.mappers;

import com.example.demo.model.dto.ApoliceSeguroDTO;
import com.example.demo.model.entities.ApoliceSeguro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApoliceSeguroMapper extends MapperBase<ApoliceSeguro, ApoliceSeguroDTO> {
    @Override
    ApoliceSeguroDTO modelToDTO(ApoliceSeguro entity);

    @Override
    ApoliceSeguro dtoToModel(ApoliceSeguroDTO dto);
}