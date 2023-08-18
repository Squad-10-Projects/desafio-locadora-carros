package com.example.demo.mappers;

import com.example.demo.model.dto.CarroDTO;
import com.example.demo.model.entities.Carro;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CarroMapper extends MapperBase<Carro, CarroDTO> {
    @Override
    CarroDTO modelToDTO(Carro entity);

    @Override
    Carro dtoToModel(CarroDTO dto);

    @Override
    List<CarroDTO> listModelToListDto(List<Carro> all);
}
