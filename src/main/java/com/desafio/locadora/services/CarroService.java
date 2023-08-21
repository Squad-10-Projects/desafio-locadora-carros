package com.desafio.locadora.services;

import com.desafio.locadora.mappers.CarroMapper;
import com.desafio.locadora.model.dto.CarroDTO;
import com.desafio.locadora.model.entities.Acessorio;
import com.desafio.locadora.model.entities.Categoria;
import com.desafio.locadora.repositories.AcessorioRepository;
import com.desafio.locadora.repositories.ModeloCarroRepository;
import com.desafio.locadora.services.exceptions.EntityNotFoundException;
import com.desafio.locadora.model.entities.Carro;
import com.desafio.locadora.model.entities.ModeloCarro;
import com.desafio.locadora.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CarroService {

    @Autowired
    private CarroRepository repository;
    @Autowired
    private CarroMapper mapper;
    @Autowired
    private ModeloCarroRepository modeloCarroRepository;
    @Autowired
    private AcessorioRepository acessorioRepository;

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

    public List<CarroDTO> listarVeiculosDisponiveis() {
        List<Carro> veiculosDisponiveis = repository.findByDisponivelTrue();
        return mapper.listModelToListDto(veiculosDisponiveis);
    }

    public List<CarroDTO> filtrarPorAcessorio(Long idAcessorio) {
        Acessorio acessorio = acessorioRepository.findById(idAcessorio)
                .orElseThrow(() -> new EntityNotFoundException("Acessório não encontrado"));

        List<Carro> carrosFiltrados = repository.findByAcessorios(acessorio);
        return carrosFiltrados.stream()
                .map(carro -> mapper.modelToDTO(carro))
                .collect(Collectors.toList());
    }

    public List<CarroDTO> filtrarPorModelo(Long modeloCarroId) {
        ModeloCarro modeloCarro = modeloCarroRepository.findById(modeloCarroId)
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));

        List<Carro> carrosPorModelo = repository.findByModeloCarro(modeloCarro);
        return carrosPorModelo.stream()
                .map(carro -> mapper.modelToDTO(carro))
                .collect(Collectors.toList());
    }

    public List<CarroDTO> filtrarPorCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não pode ser nula");
        }
        List<Carro> carrosPorCategoria = repository.findByModeloCarroCategoria(categoria);
        return carrosPorCategoria.stream()
                .map(carro -> new CarroDTO(carro))
                .collect(Collectors.toList());
    }

    public CarroDTO salvar(CarroDTO dto) {
        ModeloCarro modeloCarro = modeloCarroRepository.findById(dto.getModeloCarroId())
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));

        Carro carro = new Carro(dto, modeloCarro);
        if (dto.getAcessoriosId() != null) {
            for (Long acessoriosId : dto.getAcessoriosId()) {
                Acessorio acessorio = acessorioRepository.findById(acessoriosId)
                        .orElseThrow(() -> new EntityNotFoundException("Acessório não encontrado"));
                carro.getAcessorios().add(acessorio);
            }
        }
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
