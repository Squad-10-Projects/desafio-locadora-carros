package com.example.demo.mappers;



import com.example.demo.model.dto.ModeloCarroDTO;

import com.example.demo.model.entities.ModeloCarro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModeloCarroMapper extends MapperBase<ModeloCarro, ModeloCarroDTO> {

    @Override
    @Mapping(target = "fabricanteId", source = "entity.fabricante.id")
    ModeloCarroDTO modelToDTO(ModeloCarro entity);

    @Override
    @Mapping(target = "fabricante.id", source = "dto.fabricanteId")
    ModeloCarro dtoToModel(ModeloCarroDTO dto);

}
