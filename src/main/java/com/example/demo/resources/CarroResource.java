package com.example.demo.resources;

import com.example.demo.model.dto.CarroDTO;
import com.example.demo.model.entities.Categoria;
import com.example.demo.services.CarroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
@Tag(name = "Carro")
public class CarroResource {

    @Autowired
    private CarroService service;


    @Operation(
            description = "Retorna as informações de todos os carros registrados",
            summary = "Obtem todos os carros")
    @GetMapping
    public ResponseEntity<List<CarroDTO>> obterTodos() {
        List<CarroDTO> carros = service.obterTodos();
        return ResponseEntity.ok(carros);
    }

    @Operation(
            description = "Retorna as informações dos carros disponíveis para aluguel",
            summary = "Obtem todos os carros disponíveis")
    @GetMapping("/disponiveis")
    public List<CarroDTO> listarVeiculosDisponiveis() {
        return service.listarVeiculosDisponiveis();
    }

    @Operation(
            description = "Retorna as informações do carro pelo do id",
            summary = "Obtem um carro pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> obterPorId(@PathVariable Long id) {
        CarroDTO carroDTO = service.obterPorId(id);
        return ResponseEntity.ok(carroDTO);
    }

    @Operation(
            description = "Retorna as informações do carro que foi salvo",
            summary = "Salva um carro")
    @PostMapping
    public ResponseEntity<CarroDTO> salvar(@RequestBody CarroDTO dto) {
        CarroDTO carroDTO = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroDTO);
    }

    @Operation(
            description = "Atualiza as informações de um carro",
            summary = "Retorna as informações atualizadas do carro")
    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> atualizar(@PathVariable Long id, @RequestBody CarroDTO carroDTO) {
        CarroDTO dto = service.atualizar(id, carroDTO);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            summary = "Deleta um carro por id",
            description = "Deleta as informações do carro pelo id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            description = "Filtra os carros pelo id do acessório",
            summary = "Filtra os carros pelo acessório")
    @GetMapping("/filtrar/acessorio/{id}")
    public ResponseEntity<List<CarroDTO>> filtrarPorAcessorio(@PathVariable Long id) {
        List<CarroDTO> carrosFiltrados = service.filtrarPorAcessorio(id);
        return ResponseEntity.ok(carrosFiltrados);
    }

    @Operation(
            description = "Filtra os carros pelo id do modelo",
            summary = "Filtra os carros pelo modelo")
    @GetMapping("/filtrar/modelo/{id}")
    public ResponseEntity<List<CarroDTO>> filtrarPorModelo(@PathVariable Long id) {
        List<CarroDTO> carrosFiltrados = service.filtrarPorModelo(id);
        return ResponseEntity.ok(carrosFiltrados);
    }

    @Operation(
            description = "Filtra os carros através da categoria do modelo",
            summary = "Filtra os carros pela categoria")
    @GetMapping("/filtrar/categoria/{categoria}")
    public ResponseEntity<List<CarroDTO>> filtrarCarrosPorCategoria(@PathVariable String categoria) {
        try {
            Categoria categoriaEnum = Categoria.valueOf(categoria);
            List<CarroDTO> carrosFiltrados = service.filtrarPorCategoria(categoriaEnum);
            return ResponseEntity.ok(carrosFiltrados);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
