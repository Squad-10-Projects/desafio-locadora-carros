package com.example.demo.services;

import com.example.demo.model.entities.Motorista;
import com.example.demo.model.entities.Pessoa;
import com.example.demo.repositories.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public Motorista adicionaMotorista(Motorista motorista) {
        if(motoristaRepository.existsByEmail(motorista.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado no sistema!");
        }
        return motoristaRepository.save(motorista);
    }

    public  List<Motorista> verMotoristas() {
        return motoristaRepository.findAll();
    }

    public Optional<Motorista> verMotorista(Long id) {
        return motoristaRepository.findById(id);
    }

    public Motorista atualizarMotorista(Long id, Motorista motoristaNovo) {
        Optional<Motorista> motoristaExistente = motoristaRepository.findById(id);

        if (motoristaExistente.isPresent()) {
            Motorista motoristaAtual = motoristaExistente.get();

            motoristaAtual.setNome(motoristaNovo.getNome());
            motoristaAtual.setDataNascimento(motoristaNovo.getDataNascimento());
            motoristaAtual.setCpf(motoristaNovo.getCpf());
            motoristaAtual.setCpf(motoristaNovo.getNumeroCNH());

            return motoristaRepository.save(motoristaAtual);
        }

        return null;
    }

    public void excluirMotorista(Long id) {
        motoristaRepository.deleteById(id);
    }

    public boolean existeMotoristaComEmail(String email) {
        return motoristaRepository.existsByEmail(email);
    }
}
