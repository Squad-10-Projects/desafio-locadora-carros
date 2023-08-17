package com.example.demo.resources;

import com.example.demo.model.entities.ModeloCarro;
import com.example.demo.services.ModeloCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/modeloscarros")
public class ModeloCarroResource {

    @Autowired
    private ModeloCarroService service;

    @GetMapping
    public ResponseEntity<List<ModeloCarro>> findAll() {
        List<ModeloCarro> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}