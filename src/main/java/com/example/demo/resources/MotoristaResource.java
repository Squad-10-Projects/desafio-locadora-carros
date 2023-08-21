package com.example.demo.resources;

import com.example.demo.model.entities.Aluguel;
import com.example.demo.model.entities.Motorista;
import com.example.demo.repositories.MotoristaRepository;
import com.example.demo.services.MotoristaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Motorista")
public class MotoristaResource {

    private MotoristaService motoristaService;
    private final MotoristaRepository motoristaRepository;

    public MotoristaResource(MotoristaService motoristaService,
                             MotoristaRepository motoristaRepository) {
        super();
        this.motoristaService = motoristaService;
        this.motoristaRepository = motoristaRepository;
    }

    @Operation(
            description = "Adiciona um motorista e retorna as informações do motorista salvo",
            summary = "Salva um motorista")
    @PostMapping("/motorista/cadastro")
    public ResponseEntity<?> adicionaMotorista(@RequestBody Motorista motorista) {
        if (motoristaService.existeMotoristaComEmail(motorista.getEmail())) {
            return  new ResponseEntity<>("Email duplicado!", HttpStatus.IM_USED);
        }
        return new ResponseEntity<Motorista>(motoristaService.adicionaMotorista(motorista), HttpStatus.CREATED);
    }

    @Operation(
            description = "Retorna as informações de todos os motoristas registrados",
            summary = "Obtem todos os motoristas")
    @GetMapping("/motoristas")
    public ResponseEntity<List<Motorista>> verMotoristas() {
        return new ResponseEntity<List<Motorista>>(motoristaService.verMotoristas(), HttpStatus.OK);
    }

    @Operation(
            description = "Retorna as informações do motorista pelo id",
            summary = "Obtem um motorista pelo id")
    @GetMapping("motorista/{id}")
    public ResponseEntity<Motorista> verMotorista(@PathVariable Long id) {
        Optional<Motorista> motorista = motoristaService.verMotorista(id);

        if (motorista.isPresent()) {
            return new ResponseEntity<Motorista>(motorista.get(), HttpStatus.OK);
        }

        return new ResponseEntity<Motorista>(HttpStatus.NOT_FOUND);
    }

    @Operation(
            description = "Atualiza um motorista e retorna as informações atualizadas",
            summary = "Atualiza as informações de um motorista")
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

    @Operation(
            description = "Deleta as informações de um motorista pelo id",
            summary = "Deleta um fabricante por id")
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

    @GetMapping("/{motoristaId}/alugueis")
    public ResponseEntity<List<Aluguel>> alugueisConfirmadosEDetalhesFuturos(@PathVariable Long motoristaId) {
        List<Aluguel> alugueis = motoristaService.alugueisConfirmadosEDetalhesFuturos(motoristaId);
        return ResponseEntity.ok(alugueis);
    }
}
