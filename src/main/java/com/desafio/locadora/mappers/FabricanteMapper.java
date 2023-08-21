package com.desafio.locadora.mappers;

import com.desafio.locadora.model.entities.Fabricante;
import com.desafio.locadora.model.dto.FabricanteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FabricanteMapper extends MapperBase<Fabricante, FabricanteDTO> {
    @Override
    FabricanteDTO modelToDTO(Fabricante entity);

    @Override
    Fabricante dtoToModel(FabricanteDTO dto);

}
