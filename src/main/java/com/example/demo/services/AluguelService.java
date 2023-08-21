package com.example.demo.services;


import com.example.demo.model.entities.Aluguel;
import com.example.demo.model.entities.Motorista;
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
    @Autowired
    private MotoristaService motoristaService;

    MotoristaService ms = new MotoristaService();
    public Aluguel confirmarAluguel(List<Carro> carrosSelecionados, Aluguel aluguelConfirmado, Long motoristaID) {
        Optional<Motorista> motoristaExistente = motoristaService.verMotorista(motoristaID);
        Aluguel aluguelExistente = aluguelRepository.findById(aluguelConfirmado.getID())
                .orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado"));

        if (motoristaExistente.isPresent()){
            Motorista motorista = motoristaExistente.get();
            aluguelExistente.setCarrosSelecionados(carrosSelecionados);
            aluguelExistente.setCarro(aluguelConfirmado.getCarro());
            aluguelExistente.setMotorista(aluguelConfirmado.getMotorista());
            aluguelExistente.setDataPedido(aluguelConfirmado.getDataPedido());
            aluguelExistente.setDataDevolucao(aluguelConfirmado.getDataDevolucao());
            aluguelExistente.setQuantidadeDias(aluguelConfirmado.getQuantidadeDias());
            for (Carro carro : carrosSelecionados) {
                carro.setDisponivel(false);
                carroRepository.save(carro);
            }
        }
        return aluguelRepository.save(aluguelExistente);
    }
    public void devolverCarro(Long carroId) {
        Optional<Carro> carroOptional = carroRepository.findById(carroId);

        if (carroOptional.isPresent()) {
            Carro carro = carroOptional.get();

            if (!carro.getDisponivel()) {
                carro.setDisponivel(true);
                carroRepository.save(carro);
            } else {
                throw new RuntimeException("Este carro já está disponível, não pode ser devolvido novamente.");
            }
        } else {
            throw new EntityNotFoundException("Carro não encontrado");
        }
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
