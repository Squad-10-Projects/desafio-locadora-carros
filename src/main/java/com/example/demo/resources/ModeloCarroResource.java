package com.example.demo.resources;

import com.example.demo.model.dto.ModeloCarroDTO;
import com.example.demo.services.ModeloCarroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modeloscarros")
@Tag(name = "ModeloCarro")
public class ModeloCarroResource {

    @Autowired
    private ModeloCarroService service;

    @Operation(
            description = "Retorna as informações de todos os modelos registrados",
            summary = "Obtem todos os modelos")
    @GetMapping
    public ResponseEntity<List<ModeloCarroDTO>> obterTodos() {
        List<ModeloCarroDTO> modelos = service.obterTodos();
        return ResponseEntity.ok(modelos);
    }

    @Operation(
            description = "Retorna as informações do modelo pelo do id",
            summary = "Obtem um modelo pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<ModeloCarroDTO> obterPorId(@PathVariable Long id) {
        ModeloCarroDTO modelosDTO = service.obterPorId(id);
        return ResponseEntity.ok(modelosDTO);
    }

    @Operation(
            description = "Salva um modelo e retorna as informações salvas",
            summary = "Salva um modelo")
    @PostMapping
    public ResponseEntity<ModeloCarroDTO> salvar(@RequestBody ModeloCarroDTO dto) {
        ModeloCarroDTO modeloDTO = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modeloDTO);
    }

    @Operation(
            description = "Atualiza um modelo e retorna as informações atualizadas",
            summary = "Atualiza as informações de um modelo")
    @PutMapping("/{id}")
    public ResponseEntity<ModeloCarroDTO> atualizar(@PathVariable Long id, @RequestBody ModeloCarroDTO modeloDTO) {
        ModeloCarroDTO dto = service.atualizar(id, modeloDTO);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            summary = "Deleta um modelo por id",
            description = "Deleta as informações do modelo pelo id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

}