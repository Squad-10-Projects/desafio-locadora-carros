package com.example.demo.resources;

import com.example.demo.model.entities.Fabricante;
import com.example.demo.services.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteResource {

    @Autowired
    private FabricanteService fabricanteService;

    @GetMapping
    public ResponseEntity<List<Fabricante>> getAllFabricantes() {
        List<Fabricante> fabricantes = fabricanteService.findAll();
        return ResponseEntity.ok(fabricantes);
    }

    @PostMapping
    public ResponseEntity<Fabricante> createFabricante(@RequestBody Fabricante fabricante) {
        Fabricante createdFabricante = fabricanteService.create(fabricante);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFabricante);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFabricanteById(@PathVariable Long id) {
        Optional<Fabricante> fabricante = fabricanteService.findById(id);
        if (fabricante.isPresent()) {
            return ResponseEntity.ok(fabricante.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> updateFabricante(@PathVariable Long id, @RequestBody Fabricante fabricante) {
        Fabricante updatedFabricante = fabricanteService.update(id, fabricante);
        if (updatedFabricante != null) {
            return ResponseEntity.ok(updatedFabricante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFabricante(@PathVariable Long id) {
        fabricanteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}