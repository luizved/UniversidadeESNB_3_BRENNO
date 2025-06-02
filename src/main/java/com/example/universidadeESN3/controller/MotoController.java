package com.example.universidadeESN3.controller;

import com.example.universidadeESN3.entity.Moto;
import com.example.universidadeESN3.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> buscarTodos() {
        return ResponseEntity.ok(motoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> buscarPorId(@PathVariable Long id) {
        Moto moto = motoService.buscarPorId(id);
        if (moto != null) {
            return ResponseEntity.ok(moto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Moto> salvar(@RequestBody Moto moto) {
        return ResponseEntity.ok(motoService.salvar(moto));
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody Moto moto) {
        motoService.atualizar(moto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        motoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}