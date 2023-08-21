package com.example.demo.model.entities;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.entities.Carro;

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