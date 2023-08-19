package com.example.demo.mappers;

import com.example.demo.model.dto.AcessorioDTO;
import com.example.demo.model.entities.Acessorio;
import com.example.demo.model.entities.Carro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface AcessorioMapper extends MapperBase<Acessorio, AcessorioDTO> {

    @Override
    @Mapping(target = "carrosId", expression = "java(mapCarrosToIds(entity.getCarros()))")
    AcessorioDTO modelToDTO(Acessorio entity);

    @Override
    @Mapping(target = "carros", expression = "java(mapIdsToCarros(dto.getCarrosId()))")
    Acessorio dtoToModel(AcessorioDTO dto);

    default Long[] mapCarrosToIds(Set<Carro> carros) {
        return carros.stream()
                .map(Carro::getId)
                .toArray(Long[]::new);
    }

    default Set<Carro> mapIdsToCarros(Long[] carrosIds) {
        return carrosIds == null ? new HashSet<>() :
                Set.of(carrosIds).stream()
                        .map(carroId -> {
                            Carro carro = new Carro();
                            carro.setId(carroId);
                            return carro;
                        })
                        .collect(Collectors.toSet());
    }
}