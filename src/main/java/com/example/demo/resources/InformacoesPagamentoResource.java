package com.example.demo.resources;


import com.example.demo.model.dto.InformacoesPagamentoDTO;
import com.example.demo.services.InformacoesPagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/informacoespagamento")
@Tag(name = "InformaçõesDePagamento")
public class InformacoesPagamentoResource {

    @Autowired
    private InformacoesPagamentoService service;

    @Operation(
            description = "Retorna todas as informações de pagamento registradas",
            summary = "Obtem todos as informações")
    @GetMapping
    public ResponseEntity<List<InformacoesPagamentoDTO>> obterTodos() {
        List<InformacoesPagamentoDTO> informacoesPagamento = service.obterTodos();
        return ResponseEntity.ok(informacoesPagamento);
    }

    @Operation(
            description = "Retorna as informações de pagamento pelo id",
            summary = "Obtem as informações pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<InformacoesPagamentoDTO> obterPorId(@PathVariable Long id) {
        InformacoesPagamentoDTO informacoesPagamentoDTO = service.obterPorId(id);
        return ResponseEntity.ok(informacoesPagamentoDTO);
    }

    @Operation(
            description = "Salva as informações de pagamento e retorna o que foi salvo",
            summary = "Salva dados do pagamento")
    @PostMapping
    public ResponseEntity<InformacoesPagamentoDTO> criar(@RequestBody InformacoesPagamentoDTO dto) {
        InformacoesPagamentoDTO informacoesPagamentoDTO = service.criarInformacoesPagamento(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(informacoesPagamentoDTO);
    }

    @Operation(
            description = "Atualiza as informações de pagamento e retorna elas atualizadas",
            summary = "Atualiza as informações de pagamento")
    @PutMapping("/{id}")
    public ResponseEntity<InformacoesPagamentoDTO> atualizar(@PathVariable Long id, @RequestBody InformacoesPagamentoDTO informacoesPagamentoDTO) {
        InformacoesPagamentoDTO dto = service.atualizarInformacoesPagamento(id, informacoesPagamentoDTO);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Deleta as informações de pagamento pelo id",
            summary = "Deleta informações por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        service.deletarInformacoesPagamento(id);
        return ResponseEntity.noContent().build();
    }
}