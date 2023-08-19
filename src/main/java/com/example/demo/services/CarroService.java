package com.example.demo.services;

import com.example.demo.mappers.CarroMapper;
import com.example.demo.model.dto.CarroDTO;
import com.example.demo.model.dto.ModeloCarroDTO;
import com.example.demo.model.entities.Carro;
import com.example.demo.model.entities.Fabricante;
import com.example.demo.model.entities.ModeloCarro;
import com.example.demo.repositories.CarroRepository;
import com.example.demo.repositories.ModeloCarroRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CarroService {

    @Autowired
    private CarroRepository repository;
    @Autowired
    private CarroMapper mapper;
    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    @Transactional(readOnly = true)
    public List<CarroDTO> obterTodos() {
        List<Carro> carros = this.repository.findAll();
        return carros.stream().map(this.mapper::modelToDTO).toList();
    }

    @Transactional(readOnly = true)
    public CarroDTO obterPorId(Long id) {
        return this.mapper.modelToDTO(this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado")));
    }

    public CarroDTO salvar(CarroDTO dto) {
        ModeloCarro modeloCarro = modeloCarroRepository.findById(dto.getModeloCarroId())
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));

        Carro carro = new Carro(dto, modeloCarro);
        carro = repository.save(carro);
        return mapper.modelToDTO(carro);
    }

    public CarroDTO atualizar(Long id, CarroDTO carroDTO) {
        Carro carro = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));
        Carro carroAtualizado = mapper.dtoToModel(carroDTO);
        carroAtualizado.setId(carro.getId());
        carroAtualizado = repository.save(carroAtualizado);
        return mapper.modelToDTO(carroAtualizado);
    }

    public void deletarPorId(Long id) {
        Carro carro = repository.findById(id) .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));
        repository.delete(carro);
    }

}
