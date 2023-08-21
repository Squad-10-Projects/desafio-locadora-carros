package com.example.demo.resources;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.AluguelService;
import com.example.demo.model.entities.Aluguel;

import java.time.LocalDate;

@RestController
@RequestMapping("/aluguel")
public class AluguelResource {

    @Autowired
    private AluguelService aluguelService;

    @Operation(
            description = "Cria um novo aluguel com datas de entrega e devolução",
            summary = "Cria um novo aluguel")
    @PostMapping("/criar/{motoristaId}")
    public ResponseEntity<Aluguel> criarAluguel(
            @PathVariable Long motoristaId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataEntrega,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataDevolucao) {

        Aluguel aluguel = aluguelService.criarAluguel(motoristaId, dataEntrega, dataDevolucao);
        return ResponseEntity.ok(aluguel);
    }
}
