package com.example.demo.resources;

import com.example.demo.model.dto.AcessorioDTO;
import com.example.demo.services.AcessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/acessorios")
public class AcessorioResource {

    @Autowired
    private AcessorioService service;

    @GetMapping
    public ResponseEntity<List<AcessorioDTO>> obterTodos() {
        List<AcessorioDTO> acessorios = service.obterTodos();
        return ResponseEntity.ok(acessorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcessorioDTO> obterPorId(@PathVariable Long id) {
        AcessorioDTO acessorioDTO = service.obterPorId(id);
        return ResponseEntity.ok(acessorioDTO);
    }

    @PostMapping
    public ResponseEntity<AcessorioDTO> salvar(@RequestBody AcessorioDTO dto) {
        AcessorioDTO acessorioDTO = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(acessorioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcessorioDTO> atualizar(@PathVariable Long id, @RequestBody AcessorioDTO acessorioDTO) {
        AcessorioDTO dto = service.atualizar(id, acessorioDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
