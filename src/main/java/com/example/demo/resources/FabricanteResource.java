package com.example.demo.resources;

import com.example.demo.model.entities.Fabricante;
import com.example.demo.services.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/fabricantes")
public class FabricanteResource {

    @Autowired
    private FabricanteService service;

    @GetMapping
    public ResponseEntity<List<Fabricante>> findAll() {
        List<Fabricante> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}