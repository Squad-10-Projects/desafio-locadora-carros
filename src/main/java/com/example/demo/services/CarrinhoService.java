package com.example.demo.services;

import com.example.demo.model.entities.Carrinho;
import com.example.demo.model.entities.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private Carrinho carrinho;

    public List<Carro> listarCarrosNoCarrinho() {
        List<Carro> carrosNoCarrinho = carrinho.getCarrosSelecionados();
        return carrosNoCarrinho;
    }

    public void removerCarroDoCarrinho(int index) {
        carrinho.removerCarro(index);
    }
}