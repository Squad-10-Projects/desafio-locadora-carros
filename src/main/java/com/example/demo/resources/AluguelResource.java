package com.example.demo.resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.AluguelService;
import com.example.demo.model.entities.Aluguel;


@RestController
@RequestMapping
public class AluguelResource {

    @Autowired
    private AluguelService aluguelService;

    @PostMapping("/confirmar")
    public ResponseEntity<String> confirmarAluguel(@RequestBody Aluguel aluguel){
        Aluguel aluguelConfirmado = aluguelService.confirmarAluguel(aluguel);

        if (aluguelConfirmado != null) {
            return ResponseEntity.ok("Aluguel confirmado com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Falha ao confirmar o aluguel.");
        }
    }
}
