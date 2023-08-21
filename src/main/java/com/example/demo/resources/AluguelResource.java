package com.example.demo.resources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.AluguelService;
import com.example.demo.model.entities.Aluguel;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/aluguel")
@Tag(name = "Aluguel")
public class AluguelResource {

    @Autowired
    private AluguelService aluguelService;

    @Operation(
            description = "Cria um novo aluguel com datas de entrega e devolução e retorna todas as informações do aluguel",
            summary = "Cria um novo aluguel e retorna informações")
    @PostMapping("/criar/{motoristaId}")
    public ResponseEntity<Aluguel> criarAluguel(
            @PathVariable Long motoristaId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataEntrega,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataDevolucao) {

        Aluguel aluguel = aluguelService.criarAluguel(motoristaId, dataEntrega, dataDevolucao);
        return ResponseEntity.ok(aluguel);
    }

    @Operation(
            description = "Retorna as informações de todos os alugués",
            summary = "Obtem todos os aluguéis")
    @GetMapping
    public ResponseEntity<List<Aluguel>> obterTodos() {
        List<Aluguel> alugueis = aluguelService.obterTodos();
        return ResponseEntity.ok(alugueis);
    }

    @Operation(
            description = "Deleta um aluguel pelo seu ID",
            summary = "Deleta um aluguel")
    @DeleteMapping("/deletar/{aluguelId}")
    public ResponseEntity<Void> deletarAluguel(@PathVariable Long aluguelId) {
        aluguelService.deletarAluguel(aluguelId);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            description = "Atualiza as datas de entrega e devolução de um aluguel existente",
            summary = "Atualiza um aluguel")
    @PutMapping("/atualizar/{aluguelId}")
    public ResponseEntity<Aluguel> atualizarAluguel(
            @PathVariable Long aluguelId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataEntrega,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataDevolucao) {

        Aluguel aluguel = aluguelService.atualizarAluguel(aluguelId, dataEntrega, dataDevolucao);
        return ResponseEntity.ok(aluguel);
    }


}
