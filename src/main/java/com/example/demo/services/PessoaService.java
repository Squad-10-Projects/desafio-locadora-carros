package com.example.demo.services;

import com.example.demo.model.entities.Pessoa;
import com.example.demo.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa adicionaPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> getPessoas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> getPessoa(Long id) {
        return pessoaRepository.findById(id);
    }
    public Pessoa atualizarPessoa(Long id, Pessoa novaPessoa) {
        Optional<Pessoa> pessoaExistente = pessoaRepository.findById(id);
        if (pessoaExistente.isPresent()) {
            Pessoa pessoaAtual = pessoaExistente.get();

             pessoaAtual.setNome(novaPessoa.getNome());
             pessoaAtual.setDataNascimento(novaPessoa.getDataNascimento());
             pessoaAtual.setCpf(novaPessoa.getCpf());

            return pessoaRepository.save(pessoaAtual);
        }
        return null;
    }

    public void excluirPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}
