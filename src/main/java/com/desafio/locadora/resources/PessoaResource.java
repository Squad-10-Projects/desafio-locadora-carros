package com.desafio.locadora.resources;

import com.desafio.locadora.model.entities.Pessoa;
import com.desafio.locadora.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @Operation(
        description = "Adiciona uma pessoa e retorna as informações da pessoa que foi salva",
        summary = "Salva uma pessoa")
    @PostMapping("/pessoa")
    public ResponseEntity<?> adiconaPessoa(@RequestBody Pessoa pessoa ) {
        if (pessoaService.existePessoaComEmail(pessoa.getEmail())) {
            return new ResponseEntity<>("Email duplicado!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Pessoa>(pessoaService.adicionaPessoa(pessoa), HttpStatus.CREATED);
    }

    @Operation(
        description = "Retorna as informações de todas as pessoas registradas",
        summary = "Obtem todas as pessoas")
    @GetMapping("/pessoas")
    public ResponseEntity<List<Pessoa>> verPessoas() {
        return new ResponseEntity<List<Pessoa>>(pessoaService.verPessoas(), HttpStatus.OK);
    }

    @Operation(
        description = "Retorna as informações de uma pessoa pelo id",
        summary = "Obtem uma pessoa pelo id")
    @GetMapping("/pessoas/{id}")
    public  ResponseEntity<Pessoa> verPessoa(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.verPessoa(id);

        if (pessoa.isPresent()) {
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        }

        return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
    }

    @Operation(
        description = "Atualiza uma pessoa e retorna as informações atualizadas",
        summary = "Atualiza as informações de uma pessoa")
    @PutMapping("/pessoas/{id}")
    public ResponseEntity<Pessoa> atualizaPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Optional<Pessoa> pessoaExistente = pessoaService.verPessoa(id);

        if (pessoaExistente.isPresent()) {
            Pessoa pessoaAtualizada = pessoaService.atualizarPessoa(id, pessoa);
            return new ResponseEntity<Pessoa>(pessoaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
        description = "Deleta as informações da pessoa pelo id",
        summary = "Deleta uma pessoa por id")
    @DeleteMapping("/pessoas/{id}")
    public ResponseEntity<Void> deletaPessoa(@PathVariable Long id) {
        Optional<Pessoa> pessoaExistente = pessoaService.verPessoa(id);

        if (pessoaExistente.isPresent()) {
            pessoaService.excluirPessoa(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
