package com.example.demo.resources;

import com.example.demo.model.entities.Pessoa;
import com.example.demo.services.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PessoaResource {
    private PessoaService pessoaService;
        public PessoaResource(PessoaService pessoaService) {
            super();
            this.pessoaService = pessoaService;
        }

        @PostMapping("/pessoas")
        public ResponseEntity<Pessoa> adiconaPessoa(@RequestBody Pessoa pessoa ) {
            return new ResponseEntity<Pessoa>(pessoaService.adicionaPessoa(pessoa), HttpStatus.CREATED);
        }

        @GetMapping("/pessoas")
        public ResponseEntity<List<Pessoa>> verPessoas() {
            return new ResponseEntity<List<Pessoa>>(pessoaService.verPessoas(), HttpStatus.OK);
        }

        @GetMapping("/pessoas/{id}")
        public  ResponseEntity<Pessoa> verPessoa(@PathVariable Long id) {
            Optional<Pessoa> pessoa = pessoaService.verPessoa(id);

            if (pessoa.isPresent()) {
                return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
            }

            return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
        }

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
