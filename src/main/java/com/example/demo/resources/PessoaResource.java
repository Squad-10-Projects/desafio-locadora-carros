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
        public ResponseEntity<List<Pessoa>> getPessoas() {
            return new ResponseEntity<List<Pessoa>>(pessoaService.getPessoas(), HttpStatus.OK);
        }

        @GetMapping("/pessoas/{id}")
        public  ResponseEntity<Pessoa> getPessoa(@PathVariable Long id) {
            Optional<Pessoa> pessoa = pessoaService.getPessoa(id);

            if (pessoa.isPresent()) {
                return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
            }

            return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
        }



}
