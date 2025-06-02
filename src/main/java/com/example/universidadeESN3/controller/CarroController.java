package com.example.universidadeESN3.controller;

import com.example.universidadeESN3.entity.Carro;
import com.example.universidadeESN3.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> buscarTodos() {
        return ResponseEntity.ok(carroService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id) {
        Carro carro = carroService.buscarPorId(id);
        if (carro != null) {
            return ResponseEntity.ok(carro);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Carro> salvar(@RequestBody Carro carro) {
        return ResponseEntity.ok(carroService.salvar(carro));
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody Carro carro) {
        carroService.atualizar(carro);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        carroService.excluir(id);
        return ResponseEntity.ok().build();
    }
}