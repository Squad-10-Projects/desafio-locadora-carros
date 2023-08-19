package com.example.demo.resources;

import com.example.demo.model.dto.FabricanteDTO;
import com.example.demo.services.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteResource {

    @Autowired
    private FabricanteService service;

    @GetMapping
    public ResponseEntity<List<FabricanteDTO>> obterTodos() {
        List<FabricanteDTO> fabricantes = service.obterTodos();
        return ResponseEntity.ok(fabricantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FabricanteDTO> obterPorId(@PathVariable Long id) {
        FabricanteDTO fabricanteDTO = service.obterPorId(id);
        return ResponseEntity.ok(fabricanteDTO);
    }

    @PostMapping
    public ResponseEntity<FabricanteDTO> salvar(@RequestBody FabricanteDTO dto) {
        FabricanteDTO fabricanteDTO = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(fabricanteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FabricanteDTO> atualizar(@PathVariable Long id, @RequestBody FabricanteDTO fabricanteDTO) {
        FabricanteDTO dto = service.atualizar(id, fabricanteDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}