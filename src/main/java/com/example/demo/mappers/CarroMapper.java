package com.example.demo.mappers;

import com.example.demo.model.entities.Acessorio;
import com.example.demo.model.dto.CarroDTO;
import com.example.demo.model.entities.Carro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CarroMapper extends MapperBase<Carro, CarroDTO> {

    @Override
    @Mapping(target = "modeloCarroId", source = "entity.modeloCarro.id")
    @Mapping(target = "acessoriosId", expression = "java(mapAcessoriosToIds(entity.getAcessorios()))")
    CarroDTO modelToDTO(Carro entity);

    @Override
    @Mapping(target = "modeloCarro.id", source = "dto.modeloCarroId")
    @Mapping(target = "acessorios", expression = "java(mapIdsToAcessorios(dto.getAcessoriosId()))")
    Carro dtoToModel(CarroDTO dto);

    default Long[] mapAcessoriosToIds(Set<Acessorio> acessorios) {
        return acessorios.stream()
                .map(Acessorio::getId)
                .toArray(Long[]::new);
    }

    default Set<Acessorio> mapIdsToAcessorios(Long[] acessoriosIds) {
        return acessoriosIds == null ? new HashSet<>() :
                Set.of(acessoriosIds).stream()
                        .map(acessorioId -> {
                            Acessorio acessorio = new Acessorio();
                            acessorio.setId(acessorioId);
                            return acessorio;
                        })
                        .collect(Collectors.toSet());
    }
}
