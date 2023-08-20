package com.example.demo.resources;


import com.example.demo.model.dto.InformacoesPagamentoDTO;
import com.example.demo.services.InformacoesPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/informacoespagamento")
public class InformacoesPagamentoResource {

    @Autowired
    private InformacoesPagamentoService service;

    @GetMapping
    public ResponseEntity<List<InformacoesPagamentoDTO>> obterTodos() {
        List<InformacoesPagamentoDTO> informacoesPagamento = service.obterTodos();
        return ResponseEntity.ok(informacoesPagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformacoesPagamentoDTO> obterPorId(@PathVariable Long id) {
        InformacoesPagamentoDTO informacoesPagamentoDTO = service.obterPorId(id);
        return ResponseEntity.ok(informacoesPagamentoDTO);
    }

    @PostMapping
    public ResponseEntity<InformacoesPagamentoDTO> criar(@RequestBody InformacoesPagamentoDTO dto) {
        InformacoesPagamentoDTO informacoesPagamentoDTO = service.criarInformacoesPagamento(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(informacoesPagamentoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformacoesPagamentoDTO> atualizar(@PathVariable Long id, @RequestBody InformacoesPagamentoDTO informacoesPagamentoDTO) {
        InformacoesPagamentoDTO dto = service.atualizarInformacoesPagamento(id, informacoesPagamentoDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        service.deletarInformacoesPagamento(id);
        return ResponseEntity.noContent().build();
    }
}