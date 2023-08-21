package com.desafio.locadora.model.entities;

import org.springframework.stereotype.Component;

@Component
public class Carrinho {

    private Carro carroSelecionado;

    public Carrinho() {

    }

    public void adicionarCarro(Carro carro) {
        if (carroSelecionado == null) {
            carroSelecionado = carro;
        }
    }

    public Carro getCarroSelecionado() {
        return carroSelecionado;
    }

    public void limparCarrinho() {
        carroSelecionado = null;
    }
}