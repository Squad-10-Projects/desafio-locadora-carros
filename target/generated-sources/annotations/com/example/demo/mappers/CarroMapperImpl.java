package com.example.demo.mappers;

import com.example.demo.model.dto.CarroDTO;
import com.example.demo.model.entities.Carro;
import com.example.demo.model.entities.ModeloCarro;
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
public class CarroMapperImpl implements CarroMapper {

    @Override
    public List<CarroDTO> listModelToListDto(List<Carro> all) {
        if ( all == null ) {
            return null;
        }

        List<CarroDTO> list = new ArrayList<CarroDTO>( all.size() );
        for ( Carro carro : all ) {
            list.add( modelToDTO( carro ) );
        }

        return list;
    }

    @Override
    public CarroDTO modelToDTO(Carro entity) {
        if ( entity == null ) {
            return null;
        }

        CarroDTO carroDTO = new CarroDTO();

        carroDTO.setModeloCarroId( entityModeloCarroId( entity ) );
        carroDTO.setId( entity.getId() );
        carroDTO.setPlaca( entity.getPlaca() );
        carroDTO.setChassi( entity.getChassi() );
        carroDTO.setCor( entity.getCor() );
        carroDTO.setValorDiaria( entity.getValorDiaria() );
        carroDTO.setDisponivel( entity.getDisponivel() );

        carroDTO.setAcessoriosId( mapAcessoriosToIds(entity.getAcessorios()) );

        return carroDTO;
    }

    @Override
    public Carro dtoToModel(CarroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Carro carro = new Carro();

        carro.setModeloCarro( carroDTOToModeloCarro( dto ) );
        carro.setId( dto.getId() );
        carro.setPlaca( dto.getPlaca() );
        carro.setChassi( dto.getChassi() );
        carro.setCor( dto.getCor() );
        carro.setValorDiaria( dto.getValorDiaria() );
        carro.setDisponivel( dto.getDisponivel() );

        carro.setAcessorios( mapIdsToAcessorios(dto.getAcessoriosId()) );

        return carro;
    }

    private Long entityModeloCarroId(Carro carro) {
        if ( carro == null ) {
            return null;
        }
        ModeloCarro modeloCarro = carro.getModeloCarro();
        if ( modeloCarro == null ) {
            return null;
        }
        Long id = modeloCarro.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected ModeloCarro carroDTOToModeloCarro(CarroDTO carroDTO) {
        if ( carroDTO == null ) {
            return null;
        }

        ModeloCarro modeloCarro = new ModeloCarro();

        modeloCarro.setId( carroDTO.getModeloCarroId() );

        return modeloCarro;
    }
}
