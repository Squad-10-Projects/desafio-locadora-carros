package com.example.demo.resources;

import com.example.demo.model.entities.Carro;
import com.example.demo.services.CarrinhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
@Tag(name = "Carrinho")
public class CarrinhoResource {

    @Autowired
    private CarrinhoService service;

    @Operation(
            description = "Retorna as informações de todos os carros no carrinho",
            summary = "Obtem todos os carros no carrinho")
    @GetMapping("/carros")
    public ResponseEntity<List<Carro>> listarCarrosNoCarrinho() {
        List<Carro> carrosNoCarrinho = service.listarCarrosNoCarrinho();
        return ResponseEntity.ok(carrosNoCarrinho);
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
            description = "Remove um carro ao carrinho pelo index e retorna uma mensagem de confirmação",
            summary = "Remove um carro do carrinho")
    @DeleteMapping("/remover/{carroIndex}")
    public ResponseEntity<String> removerDoCarrinho(@PathVariable int carroIndex) {
        service.removerCarroDoCarrinho(carroIndex);
        return ResponseEntity.ok("Carro removido do carrinho");
    }

    @Operation(
            description = "Remove todos os carros do carrinho e retorna uma mensagem de confirmação",
            summary = "Remove todos os carros do carrinho")
    @DeleteMapping("/limpar")
    public ResponseEntity<String> limparCarrinho() {
        service.limparCarrinho();
        return ResponseEntity.ok("Carrinho foi limpo");
    }
}