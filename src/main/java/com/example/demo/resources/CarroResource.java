package com.example.demo.resources;

import com.example.demo.model.dto.CarroDTO;
import com.example.demo.model.entities.Carro;
import com.example.demo.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/carros")
public class CarroResource {

    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<List<CarroDTO>> findAll() {
        List<CarroDTO> list = service.obterTodos();
        return ResponseEntity.ok().body(list);
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<CarroDTO> findById(@PathVariable Long id) {
//        CarroDTO dto = service.findById(id);
//        return ResponseEntity.ok().body(dto);
//    }
//
//    @PostMapping
//    public ResponseEntity<CarroDTO> insert(@RequestBody CarroDTO dto) {
//        dto = service.insert(dto);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
//        return ResponseEntity.created(uri).body(dto);
//    }
}
