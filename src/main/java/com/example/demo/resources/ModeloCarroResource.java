package com.example.demo.resources;

import com.example.demo.mappers.ModeloCarroMapper;
import com.example.demo.model.dto.FabricanteDTO;
import com.example.demo.model.dto.ModeloCarroDTO;
import com.example.demo.model.entities.Fabricante;
import com.example.demo.model.entities.ModeloCarro;
import com.example.demo.repositories.FabricanteRepository;
import com.example.demo.services.ModeloCarroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modeloscarros")
public class ModeloCarroResource {

    @Autowired
    private ModeloCarroService service;

    @GetMapping
    public ResponseEntity<List<ModeloCarroDTO>> obterTodos() {
        List<ModeloCarroDTO> modelos = service.obterTodos();
        return ResponseEntity.ok(modelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloCarroDTO> obterPorId(@PathVariable Long id) {
        ModeloCarroDTO modelosDTO = service.obterPorId(id);
        return ResponseEntity.ok(modelosDTO);
    }

    @PostMapping
    public ResponseEntity<ModeloCarroDTO> salvar(@RequestBody ModeloCarroDTO dto) {
        ModeloCarroDTO modeloDTO = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modeloDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloCarroDTO> atualizar(@PathVariable Long id, @RequestBody ModeloCarroDTO modeloDTO) {
        ModeloCarroDTO dto = service.atualizar(id, modeloDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

}