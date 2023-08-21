package com.desafio.locadora.resources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.desafio.locadora.services.AluguelService;
import com.desafio.locadora.model.entities.Aluguel;

import java.time.LocalDate;

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
}
