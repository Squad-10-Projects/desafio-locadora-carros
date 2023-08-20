package com.example.demo.model.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.entities.Carro;

@Component
public class Carrinho {

    private List<Carro> carrosSelecionados;
    private List<Aluguel> alugueisEmAndamento;

    public Carrinho() {

        carrosSelecionados = new ArrayList<>();
    }

    public void adicionarCarro(Carro carro) {
        carrosSelecionados.add(carro);
    }

    public void removerCarro(int index) {
        if (index >= 0 && index < carrosSelecionados.size()) {
            carrosSelecionados.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
        }
    }
    public void adicionarAluguel(Aluguel aluguel) {
        alugueisEmAndamento.add(aluguel);
    }
    public List<Carro> getCarrosSelecionados() {
        return carrosSelecionados;
    }

    public void setCarrosSelecionados(List<Carro> carrosSelecionados) {
        this.carrosSelecionados = carrosSelecionados;
    }

    public void limparCarrinho() {
        carrosSelecionados.clear();
    }
}