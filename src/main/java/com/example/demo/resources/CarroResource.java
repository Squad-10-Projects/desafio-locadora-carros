package com.example.demo.resources;

import com.example.demo.model.dto.CarroDTO;
import com.example.demo.model.entities.Categoria;
import com.example.demo.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroResource {

    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<List<CarroDTO>> obterTodos() {
        List<CarroDTO> carros = service.obterTodos();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/disponiveis")
    public List<CarroDTO> listarVeiculosDisponiveis() {
        return service.listarVeiculosDisponiveis();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> obterPorId(@PathVariable Long id) {
        CarroDTO carroDTO = service.obterPorId(id);
        return ResponseEntity.ok(carroDTO);
    }

    @PostMapping
    public ResponseEntity<CarroDTO> salvar(@RequestBody CarroDTO dto) {
        CarroDTO carroDTO = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> atualizar(@PathVariable Long id, @RequestBody CarroDTO carroDTO) {
        CarroDTO dto = service.atualizar(id, carroDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtrar/acessorio/{id}")
    public ResponseEntity<List<CarroDTO>> filtrarPorAcessorio(@PathVariable Long id) {
        List<CarroDTO> carrosFiltrados = service.filtrarPorAcessorio(id);
        return ResponseEntity.ok(carrosFiltrados);
    }

    @GetMapping("/filtrar/modelo/{id}")
    public ResponseEntity<List<CarroDTO>> filtrarPorModelo(@PathVariable Long modeloCarroId) {
        List<CarroDTO> carrosFiltrados = service.filtrarPorModelo(modeloCarroId);
        return ResponseEntity.ok(carrosFiltrados);
    }

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
