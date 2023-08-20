package com.example.demo.resources;

import com.example.demo.model.dto.AcessorioDTO;
import com.example.demo.services.AcessorioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/acessorios")
@Tag(name = "Acessório")
public class AcessorioResource {

    @Autowired
    private AcessorioService service;

    @Operation(
            description = "Retorna as informações de todos os acessórios registrados",
            summary = "Obtem todos os acessórios")
    @GetMapping
    public ResponseEntity<List<AcessorioDTO>> obterTodos() {
        List<AcessorioDTO> acessorios = service.obterTodos();
        return ResponseEntity.ok(acessorios);
    }

    @Operation(
            description = "Retorna as informações do acessório pelo id",
            summary = "Obtem um acessório pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<AcessorioDTO> obterPorId(@PathVariable Long id) {
        AcessorioDTO acessorioDTO = service.obterPorId(id);
        return ResponseEntity.ok(acessorioDTO);
    }

    @Operation(
            description = "Salva um acessório e retorna as informações do acessório que foi salvo",
            summary = "Salva um acessório")
    @PostMapping
    public ResponseEntity<AcessorioDTO> salvar(@RequestBody AcessorioDTO dto) {
        AcessorioDTO acessorioDTO = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(acessorioDTO);
    }

    @Operation(
            description = "Atualiza um acessório e retorna as informações atualizadas",
            summary = "Atualiza as informações de um acessório")
    @PutMapping("/{id}")
    public ResponseEntity<AcessorioDTO> atualizar(@PathVariable Long id, @RequestBody AcessorioDTO acessorioDTO) {
        AcessorioDTO dto = service.atualizar(id, acessorioDTO);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Deleta as informações do acessório pelo id",
            summary = "Deleta um acessório por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
