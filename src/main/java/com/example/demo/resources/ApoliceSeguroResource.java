package com.example.demo.resources;

import com.example.demo.model.dto.ApoliceSeguroDTO;
import com.example.demo.services.ApoliceSeguroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apolicesseguro")
@Tag(name = "ApoliceSeguro")
public class ApoliceSeguroResource {

    @Autowired
    private ApoliceSeguroService service;

    @Operation(
            description = "Retorna as informações de todas as apólices de seguro registradas",
            summary = "Obtém todas as apólices de seguro")
    @GetMapping
    public ResponseEntity<List<ApoliceSeguroDTO>> obterTodos() {
        List<ApoliceSeguroDTO> apolices = service.obterTodos();
        return ResponseEntity.ok(apolices);
    }

    @Operation(
            description = "Retorna as informações da apólice de seguro pelo id",
            summary = "Obtém uma apólice de seguro pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<ApoliceSeguroDTO> obterPorId(@PathVariable Long id) {
        ApoliceSeguroDTO apoliceDTO = service.obterPorId(id);
        return ResponseEntity.ok(apoliceDTO);
    }

    @Operation(
            description = "Salva uma apólice de seguro e retorna as informações da apólice que foi salva",
            summary = "Salva uma apólice de seguro")
    @PostMapping
    public ResponseEntity<ApoliceSeguroDTO> salvar(@RequestBody ApoliceSeguroDTO dto, @RequestParam Long aluguelId) {
        ApoliceSeguroDTO apoliceDTO = service.salvar(dto, aluguelId);
        return ResponseEntity.status(HttpStatus.CREATED).body(apoliceDTO);
    }

    @Operation(
            description = "Atualiza uma apólice de seguro e retorna as informações atualizadas",
            summary = "Atualiza as informações de uma apólice de seguro")
    @PutMapping("/{id}")
    public ResponseEntity<ApoliceSeguroDTO> atualizar(@PathVariable Long id, @RequestBody ApoliceSeguroDTO apoliceDTO) {
        ApoliceSeguroDTO dto = service.atualizar(id, apoliceDTO);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Deleta as informações da apólice de seguro pelo id",
            summary = "Deleta uma apólice de seguro por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}