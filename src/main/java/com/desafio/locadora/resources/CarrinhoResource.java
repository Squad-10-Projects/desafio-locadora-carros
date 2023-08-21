package com.desafio.locadora.resources;

import com.desafio.locadora.model.entities.Carro;
import com.desafio.locadora.services.CarrinhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
@Tag(name = "Carrinho")
public class CarrinhoResource {

    @Autowired
    private CarrinhoService service;

    @Operation(
            description = "Retorna o carro selecionado no carrinho",
            summary = "Obtem o carro selecionado no carrinho")
    @GetMapping
    public ResponseEntity<Carro> obterCarroSelecionado() {
        Carro carroSelecionado = service.listarCarroNoCarrinho();

        if (carroSelecionado != null) {
            return ResponseEntity.ok(carroSelecionado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            description = "Adicionar um carro ao carrinho pelo id e retorna uma mensagem de confirmação",
            summary = "Adiciona um carro ao carrinho")
    @PostMapping("/adicionar/{carroId}")
    public ResponseEntity<String> adicionarAoCarrinho(@PathVariable Long carroId) {
        service.adicionarCarroAoCarrinho(carroId);
        return ResponseEntity.ok("Carro adicionado ao carrinho");
    }

    @Operation(
            description = "Remove o carro do carrinho e retorna uma mensagem de confirmação",
            summary = "Remove o carro do carrinho")
    @DeleteMapping("/remover")
    public ResponseEntity<String> removerDoCarrinho() {
        service.removerCarroDoCarrinho();
        return ResponseEntity.ok("Carro removido do carrinho");
    }

}