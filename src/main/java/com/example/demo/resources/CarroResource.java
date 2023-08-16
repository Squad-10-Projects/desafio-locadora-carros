package com.example.demo.resources;

import com.example.demo.model.entities.Carro;
import com.example.demo.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/carros")
public class CarroResource {

    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<List<Carro>> findAll() {
        List<Carro> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
