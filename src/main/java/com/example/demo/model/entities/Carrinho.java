package com.example.demo.model.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Carrinho {

    private List<Carro> carrosSelecionados;

    public Carrinho() {
        carrosSelecionados = new ArrayList<>();
    }

    public void adicionarCarro(Carro carro) {
        carrosSelecionados.add(carro);
    }

    public List<Carro> getCarrosSelecionados() {
        return carrosSelecionados;
    }

    public void limparCarrinho() {
        carrosSelecionados.clear();
    }
}