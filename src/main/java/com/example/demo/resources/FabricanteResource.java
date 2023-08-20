package com.example.demo.resources;

import com.example.demo.model.dto.FabricanteDTO;
import com.example.demo.services.FabricanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fabricantes")
@Tag(name = "Fabricante")
public class FabricanteResource {

    @Autowired
    private FabricanteService service;

    @Operation(
            description = "Retorna as informações de todos os fabricantes registrados",
            summary = "Obtem todos os fabricantes")
    @GetMapping
    public ResponseEntity<List<FabricanteDTO>> obterTodos() {
        List<FabricanteDTO> fabricantes = service.obterTodos();
        return ResponseEntity.ok(fabricantes);
    }

    @Operation(
            description = "Retorna as informações do fabricante pelo id",
            summary = "Obtem um fabricante pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<FabricanteDTO> obterPorId(@PathVariable Long id) {
        FabricanteDTO fabricanteDTO = service.obterPorId(id);
        return ResponseEntity.ok(fabricanteDTO);
    }

    @Operation(
            description = "Salva um fabricante e retorna as informações do fabricante que foi salvo",
            summary = "Salva um fabricante")
    @PostMapping
    public ResponseEntity<FabricanteDTO> salvar(@RequestBody FabricanteDTO dto) {
        FabricanteDTO fabricanteDTO = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(fabricanteDTO);
    }

    @Operation(
            description = "Atualiza um fabricante e retorna as informações atualizadas",
            summary = "Atualiza as informações de um fabricante")
    @PutMapping("/{id}")
    public ResponseEntity<FabricanteDTO> atualizar(@PathVariable Long id, @RequestBody FabricanteDTO fabricanteDTO) {
        FabricanteDTO dto = service.atualizar(id, fabricanteDTO);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Deleta as informações do fabricante pelo id",
            summary = "Deleta um fabricante por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}