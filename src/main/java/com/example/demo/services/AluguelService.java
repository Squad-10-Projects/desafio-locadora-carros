package com.example.demo.services;


import com.example.demo.model.entities.Aluguel;
import com.example.demo.model.entities.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.AluguelRepository;

import java.util.List;
import java.util.Optional;


@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    public Aluguel confirmarAluguel(Aluguel aluguelConfirmado) {
        Aluguel aluguel = new Aluguel();
        return aluguelRepository.save(aluguel);
    }
    public List<Aluguel> getAluguel() {
        return aluguelRepository.findAll();
    }
    public Optional<Aluguel> getAluguel(Long id) {
        return aluguelRepository.findById(id);
    }
}
