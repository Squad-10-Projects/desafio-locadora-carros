package com.example.demo.resources;

import com.example.demo.model.entities.Carrinho;
import com.example.demo.model.entities.Carro;
import com.example.demo.repositories.CarroRepository;
import com.example.demo.services.CarrinhoService;
import com.example.demo.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoResource {
    @Autowired
    private Carrinho carrinho;
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private CarrinhoService service;

    @PostMapping("/adicionar/{carroId}")
    public ResponseEntity<String> adicionarAoCarrinho(@PathVariable Long carroId) {
        Carro carro = carroRepository.findById(carroId)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));

        carrinho.adicionarCarro(carro);

        return ResponseEntity.ok("Carro adicionado ao carrinho");
    }

    @GetMapping("/carros")
    public ResponseEntity<List<Carro>> listarCarrosNoCarrinho() {
        List<Carro> carrosNoCarrinho = service.listarCarrosNoCarrinho();
        return ResponseEntity.ok(carrosNoCarrinho);
    }

}