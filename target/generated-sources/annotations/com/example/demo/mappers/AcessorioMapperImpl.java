package com.example.demo.mappers;

import com.example.demo.model.dto.AcessorioDTO;
import com.example.demo.model.entities.Acessorio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-21T02:31:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class AcessorioMapperImpl implements AcessorioMapper {

    @Override
    public List<AcessorioDTO> listModelToListDto(List<Acessorio> all) {
        if ( all == null ) {
            return null;
        }

        List<AcessorioDTO> list = new ArrayList<AcessorioDTO>( all.size() );
        for ( Acessorio acessorio : all ) {
            list.add( modelToDTO( acessorio ) );
        }

        return list;
    }

    @Override
    public AcessorioDTO modelToDTO(Acessorio entity) {
        if ( entity == null ) {
            return null;
        }

        AcessorioDTO acessorioDTO = new AcessorioDTO();

        acessorioDTO.setId( entity.getId() );
        acessorioDTO.setDescricao( entity.getDescricao() );

        return acessorioDTO;
    }

    @Override
    public Acessorio dtoToModel(AcessorioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Acessorio acessorio = new Acessorio();

        acessorio.setDescricao( dto.getDescricao() );
        acessorio.setId( dto.getId() );

        return acessorio;
    }
}
