package com.example.demo.resources;

import com.example.demo.model.dto.ModeloCarroDTO;
import com.example.demo.model.entities.ModeloCarro;
import com.example.demo.services.ModeloCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modeloscarros")
public class ModeloCarroResource {

    @Autowired
    private ModeloCarroService modeloCarroService;

    @GetMapping
    public ResponseEntity<List<ModeloCarroDTO>> getAllModelosCarros() {
        List<ModeloCarro> modelosCarros = modeloCarroService.findAll();

        List<ModeloCarroDTO> modelosCarrosDTO = new ArrayList<>();
        for (ModeloCarro modeloCarro : modelosCarros) {
            modelosCarrosDTO.add(modeloCarroService.toDTO(modeloCarro));
        }

        return ResponseEntity.ok(modelosCarrosDTO);

    }

    @PostMapping
    public ResponseEntity<ModeloCarro> createModeloCarro(@RequestBody ModeloCarro modeloCarro) {
        ModeloCarro createdModeloCarro = modeloCarroService.create(modeloCarro);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModeloCarro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getModeloCarroById(@PathVariable Long id) {
        Optional<ModeloCarro> modeloCarro = modeloCarroService.findById(id);
        if (modeloCarro.isPresent()) {
            ModeloCarroDTO modeloCarroDTO = modeloCarroService.toDTO(modeloCarro.get());
            return ResponseEntity.ok(modeloCarroDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloCarro> updateModeloCarro(@PathVariable Long id, @RequestBody ModeloCarro modeloCarro) {
        ModeloCarro updatedModeloCarro = modeloCarroService.update(id, modeloCarro);
        if (updatedModeloCarro != null) {
            return ResponseEntity.ok(updatedModeloCarro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModeloCarro(@PathVariable Long id) {
        modeloCarroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}