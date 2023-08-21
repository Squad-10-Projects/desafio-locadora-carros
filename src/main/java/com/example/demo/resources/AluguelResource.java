package com.example.demo.resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.AluguelService;
import com.example.demo.model.entities.Aluguel;
import com.example.demo.model.entities.Carrinho;
import com.example.demo.model.entities.Carro;
import java.util.List;
import com.example.demo.repositories.AluguelRepository;


@RestController
@RequestMapping("/aluguel")
public class AluguelResource {

    @Autowired
    private AluguelService aluguelService;
    @Autowired
    private Carrinho carrinho;

    @PostMapping("/confirmar/{motoristaID}")
    public ResponseEntity<String> confirmarAluguel(@RequestBody Aluguel aluguel,@PathVariable Long motoristaID){
        List<Carro> carrosSelecionados = carrinho.getCarrosSelecionados();
        if (carrosSelecionados.isEmpty()) {
            return ResponseEntity.badRequest().body("O carrinho está vazio");
        }
        Aluguel aluguelConfirmado = new Aluguel();
        aluguelConfirmado.setCarrosSelecionados(carrosSelecionados);
        aluguelService.confirmarAluguel(carrosSelecionados, aluguelConfirmado, motoristaID);
        carrinho.limparCarrinho();
        return ResponseEntity.ok("Aluguel concluído com sucesso");


    }
}
