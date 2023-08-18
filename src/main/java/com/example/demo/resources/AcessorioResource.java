package com.example.demo.resources;

import com.example.demo.model.entities.Acessorio;
import com.example.demo.model.entities.Carro;
import com.example.demo.services.AcessorioService;
import com.example.demo.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/acessorios")
public class AcessorioResource {

    @Autowired
    private AcessorioService service;

    @GetMapping
    public ResponseEntity<List<Acessorio>> findAll() {
        List<Acessorio> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
