package com.desafio.locadora.mappers;



import com.desafio.locadora.model.dto.ModeloCarroDTO;

import com.desafio.locadora.model.entities.ModeloCarro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModeloCarroMapper extends MapperBase<ModeloCarro, ModeloCarroDTO> {

    @Override
    @Mapping(target = "fabricanteId", source = "entity.fabricante.id")
    ModeloCarroDTO modelToDTO(ModeloCarro entity);

    @Override
    @Mapping(target = "fabricante.id", source = "dto.fabricanteId")
    ModeloCarro dtoToModel(ModeloCarroDTO dto);

}
