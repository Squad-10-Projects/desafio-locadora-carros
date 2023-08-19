package com.example.demo.mappers;

import com.example.demo.model.dto.CarroDTO;
import com.example.demo.model.entities.Carro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarroMapper extends MapperBase<Carro, CarroDTO> {

    @Override
    @Mapping(target = "modeloCarroId", source = "entity.modeloCarro.id")
    CarroDTO modelToDTO(Carro entity);

    @Override
    @Mapping(target = "modeloCarro.id", source = "dto.modeloCarroId")
    Carro dtoToModel(CarroDTO dto);

    @Override
    List<CarroDTO> listModelToListDto(List<Carro> all);
}
