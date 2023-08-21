package com.example.demo.mappers;

import com.example.demo.model.dto.ModeloCarroDTO;
import com.example.demo.model.entities.Fabricante;
import com.example.demo.model.entities.ModeloCarro;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-21T02:10:00-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class ModeloCarroMapperImpl implements ModeloCarroMapper {

    @Override
    public List<ModeloCarroDTO> listModelToListDto(List<ModeloCarro> all) {
        if ( all == null ) {
            return null;
        }

        List<ModeloCarroDTO> list = new ArrayList<ModeloCarroDTO>( all.size() );
        for ( ModeloCarro modeloCarro : all ) {
            list.add( modelToDTO( modeloCarro ) );
        }

        return list;
    }

    @Override
    public ModeloCarroDTO modelToDTO(ModeloCarro entity) {
        if ( entity == null ) {
            return null;
        }

        ModeloCarroDTO modeloCarroDTO = new ModeloCarroDTO();

        modeloCarroDTO.setFabricanteId( entityFabricanteId( entity ) );
        modeloCarroDTO.setId( entity.getId() );
        modeloCarroDTO.setDescricao( entity.getDescricao() );
        modeloCarroDTO.setCategoria( entity.getCategoria() );

        return modeloCarroDTO;
    }

    @Override
    public ModeloCarro dtoToModel(ModeloCarroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ModeloCarro modeloCarro = new ModeloCarro();

        modeloCarro.setFabricante( modeloCarroDTOToFabricante( dto ) );
        modeloCarro.setId( dto.getId() );
        modeloCarro.setDescricao( dto.getDescricao() );
        modeloCarro.setCategoria( dto.getCategoria() );

        return modeloCarro;
    }

    private Long entityFabricanteId(ModeloCarro modeloCarro) {
        if ( modeloCarro == null ) {
            return null;
        }
        Fabricante fabricante = modeloCarro.getFabricante();
        if ( fabricante == null ) {
            return null;
        }
        Long id = fabricante.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Fabricante modeloCarroDTOToFabricante(ModeloCarroDTO modeloCarroDTO) {
        if ( modeloCarroDTO == null ) {
            return null;
        }

        Fabricante fabricante = new Fabricante();

        fabricante.setId( modeloCarroDTO.getFabricanteId() );

        return fabricante;
    }
}
