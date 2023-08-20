package com.example.demo.services;

import com.example.demo.model.entities.Carrinho;
import com.example.demo.model.entities.Carro;
import com.example.demo.repositories.CarroRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private Carrinho carrinho;

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> listarCarrosNoCarrinho() {
        List<Carro> carrosNoCarrinho = carrinho.getCarrosSelecionados();
        return carrosNoCarrinho;
    }

    public void adicionarCarroAoCarrinho(Long carroId) {
        Carro carro = carroRepository.findById(carroId)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));
        carrinho.adicionarCarro(carro);
    }

    public void removerCarroDoCarrinho(int index) {
        carrinho.removerCarro(index);
    }

    public void limparCarrinho() {
        carrinho.limparCarrinho();
    }
}