package com.example.demo.mappers;

import com.example.demo.model.dto.FabricanteDTO;
import com.example.demo.model.entities.Fabricante;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-21T19:13:15-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class FabricanteMapperImpl implements FabricanteMapper {

    @Override
    public List<FabricanteDTO> listModelToListDto(List<Fabricante> all) {
        if ( all == null ) {
            return null;
        }

        List<FabricanteDTO> list = new ArrayList<FabricanteDTO>( all.size() );
        for ( Fabricante fabricante : all ) {
            list.add( modelToDTO( fabricante ) );
        }

        return list;
    }

    @Override
    public FabricanteDTO modelToDTO(Fabricante entity) {
        if ( entity == null ) {
            return null;
        }

        FabricanteDTO fabricanteDTO = new FabricanteDTO();

        fabricanteDTO.setId( entity.getId() );
        fabricanteDTO.setNome( entity.getNome() );

        return fabricanteDTO;
    }

    @Override
    public Fabricante dtoToModel(FabricanteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Fabricante fabricante = new Fabricante();

        fabricante.setId( dto.getId() );
        fabricante.setNome( dto.getNome() );

        return fabricante;
    }
}
