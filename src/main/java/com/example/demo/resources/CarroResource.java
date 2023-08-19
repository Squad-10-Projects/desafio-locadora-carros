package com.example.demo.resources;

import com.example.demo.model.dto.CarroDTO;
import com.example.demo.services.CarroService;
import com.example.demo.services.exceptions.EntityNotFoundException;
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
}
