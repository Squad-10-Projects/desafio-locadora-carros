package com.example.demo.mappers;

import com.example.demo.model.dto.CarroDTO;
import com.example.demo.model.dto.FabricanteDTO;
import com.example.demo.model.entities.Carro;
import com.example.demo.model.entities.Fabricante;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FabricanteMapper extends MapperBase<Fabricante, FabricanteDTO> {
    @Override
    FabricanteDTO modelToDTO(Fabricante entity);

    @Override
    Fabricante dtoToModel(FabricanteDTO dto);

}
