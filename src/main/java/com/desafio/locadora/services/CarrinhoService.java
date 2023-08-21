package com.desafio.locadora.services;

import com.desafio.locadora.model.entities.Carro;
import com.desafio.locadora.repositories.CarroRepository;
import com.desafio.locadora.services.exceptions.EntityNotFoundException;
import com.desafio.locadora.model.entities.Carrinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    private Carrinho carrinho;

    @Autowired
    private CarroRepository carroRepository;

    public Carro listarCarroNoCarrinho() {
        return carrinho.getCarroSelecionado();
    }

    public void adicionarCarroAoCarrinho(Long carroId) {
        if (carrinho.getCarroSelecionado() == null) {
            Carro carro = carroRepository.findById(carroId)
                    .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));
            carrinho.adicionarCarro(carro);
        }
    }

    public void removerCarroDoCarrinho() {
        carrinho.limparCarrinho();
    }

}