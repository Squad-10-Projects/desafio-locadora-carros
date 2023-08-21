package com.desafio.locadora.services;

import com.desafio.locadora.repositories.AluguelRepository;
import com.desafio.locadora.services.exceptions.EntityNotFoundException;
import com.desafio.locadora.model.entities.Aluguel;
import com.desafio.locadora.model.entities.Carrinho;
import com.desafio.locadora.model.entities.Motorista;
import com.desafio.locadora.repositories.CarroRepository;
import com.desafio.locadora.repositories.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafio.locadora.model.entities.Carro;
import java.time.LocalDate;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private Carrinho carrinho;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private CarroRepository carroRepository;

    public Aluguel criarAluguel(Long motoristaId,LocalDate dataEntrega, LocalDate dataDevolucao) {
        Motorista motorista = motoristaRepository.findById(motoristaId)
                .orElseThrow(() -> new EntityNotFoundException("Motorista não encontrado"));
        Carro carroSelecionado = carrinho.getCarroSelecionado();
        if (carroSelecionado == null) {
            throw new IllegalStateException("Nenhum carro selecionado no carrinho");
        }

        Aluguel aluguel = new Aluguel(dataEntrega, dataDevolucao, motorista, carroSelecionado);
        aluguelRepository.save(aluguel);

        carroSelecionado.setDisponivel(false);
        carroRepository.save(carroSelecionado);

        carrinho.limparCarrinho();

        return aluguel;
    }
}
