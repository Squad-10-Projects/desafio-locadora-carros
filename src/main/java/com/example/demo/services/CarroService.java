package com.example.demo.services;

import com.example.demo.model.dto.CarroDTO;
import com.example.demo.model.entities.Carro;
import com.example.demo.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    @Transactional(readOnly = true)
    public List<CarroDTO> findAll() {
        List<Carro> list = repository.findAll();
        return list.stream().map(x -> new CarroDTO(x)).collect(Collectors.toList());
    }
}
