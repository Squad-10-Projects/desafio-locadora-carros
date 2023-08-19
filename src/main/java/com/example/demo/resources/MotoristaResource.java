package com.example.demo.resources;

import com.example.demo.model.entities.Motorista;
import com.example.demo.model.entities.Pessoa;
import com.example.demo.repositories.MotoristaRepository;
import com.example.demo.services.MotoristaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MotoristaResource {
    private MotoristaService motoristaService;
    private final MotoristaRepository motoristaRepository;

    public MotoristaResource(MotoristaService motoristaService,
                             MotoristaRepository motoristaRepository) {
        super();
        this.motoristaService = motoristaService;
        this.motoristaRepository = motoristaRepository;
    }

    @PostMapping("/motorista")
    public ResponseEntity<Motorista> adicionaMotorista(@RequestBody Motorista motorista) {
        return new ResponseEntity<Motorista>(motoristaService.adicionaMotorista(motorista), HttpStatus.CREATED);
    }

    @GetMapping("/motoristas")
    public ResponseEntity<List<Motorista>> verMotoristas() {
        return new ResponseEntity<List<Motorista>>(motoristaService.verMotoristas(), HttpStatus.OK);
    }

    @GetMapping("motorista/{id}")
    public ResponseEntity<Motorista> verMotorista(@PathVariable Long id) {
        Optional<Motorista> motorista = motoristaService.verMotorista(id);

        if (motorista.isPresent()) {
            return new ResponseEntity<Motorista>(motorista.get(), HttpStatus.OK);
        }

        return new ResponseEntity<Motorista>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/motorista/{id}")
    public ResponseEntity<Motorista> atualizaMotorista(@PathVariable Long id, @RequestBody Motorista motorista) {
        Optional<Motorista> motoristaExistente = motoristaService.verMotorista(id);
        if (motoristaExistente.isPresent()) {
            Motorista motoristaAtualizado = motoristaService.atualizarMotorista(id, motorista);
            return new ResponseEntity<Motorista>(motoristaAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<Motorista>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/motorista/{id}")
    public ResponseEntity<Void> deletaMotorista(@PathVariable Long id) {
        Optional<Motorista> motoristaExistente = motoristaService.verMotorista(id);

        if (motoristaExistente.isPresent()) {
            motoristaService.excluirMotorista(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
