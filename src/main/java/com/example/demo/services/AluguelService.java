package com.example.demo.services;


import com.example.demo.model.entities.Aluguel;
import com.example.demo.repositories.CarroRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.AluguelRepository;
import com.example.demo.model.entities.Carro;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private CarroRepository carroRepository;

    public Aluguel confirmarAluguel(Aluguel aluguelConfirmado) {

        Aluguel aluguelExistente = aluguelRepository.findById(aluguelConfirmado.getId())
                .orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado"));

        aluguelExistente.setCarro(aluguelConfirmado.getCarro());
        aluguelExistente.setPessoa(aluguelConfirmado.getPessoa());
        aluguelExistente.setDataPedido(aluguelConfirmado.getDataPedido());
        aluguelExistente.setDataDevolucao(aluguelConfirmado.getDataDevolucao());
        aluguelExistente.setQuantidadeDias(aluguelConfirmado.getQuantidadeDias());

        return aluguelRepository.save(aluguelExistente);

    }

        public Aluguel carroAluguel(Long aluguelId, Long carroId){
        Aluguel aluguel = aluguelRepository.findById(aluguelId).orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado"));
        Carro carro = carroRepository.findById(carroId).orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));

        aluguel.setCarro(carro);

        return aluguelRepository.save(aluguel);
    }

    public BigDecimal calcularValorAluguel(Aluguel aluguel){
        Carro carro = aluguel.getCarro();
        BigDecimal valorDiaria = carro.getValorDiaria();
        int quantidadeDias = aluguel.getQuantidadeDias();
        BigDecimal valorTotal = valorDiaria.multiply(BigDecimal.valueOf(quantidadeDias));
        return valorTotal;
    }
    public List<Aluguel> getAluguel() {
        return aluguelRepository.findAll();
    }
    public Optional<Aluguel> getAluguel(Long id) {
        return aluguelRepository.findById(id);
    }
}
