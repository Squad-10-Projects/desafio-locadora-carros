package com.example.demo.services;

import com.example.demo.mappers.CarroMapper;
import com.example.demo.model.dto.CarroDTO;
import com.example.demo.model.entities.Carro;
import com.example.demo.repositories.CarroRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    private CarroRepository repository;
    @Autowired
    private CarroMapper mapper;

//    @Transactional(readOnly = true)
//    public List<CarroDTO> findAll() {
//        List<Carro> list = repository.findAll();
//        return list.stream().map(x -> new CarroDTO(x)).collect(Collectors.toList());
//    }
    @Transactional(readOnly = true)
    public List<CarroDTO> obterTodos() {
        List<Carro> carros = this.repository.findAll();
        return carros.stream().map(this.mapper::modelToDTO).toList();
    }

//    @Transactional(readOnly = true)
//    public CarroDTO findById(Long id) {
//        Optional<Carro> obj = repository.findById(id);
//        Carro entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
//        return new CarroDTO(entity);
//    }
//
//    public CarroDTO insert(CarroDTO dto) {
//        Carro entity = new Carro();
//        entity.setChassi(dto.getChassi());
//        entity.setPlaca(dto.getPlaca());
//        entity.setCor(dto.getCor());
//        entity.setValorDiaria(dto.getValorDiaria());
//        entity = repository.save(entity);
//        return new CarroDTO(entity);
//    }
}
