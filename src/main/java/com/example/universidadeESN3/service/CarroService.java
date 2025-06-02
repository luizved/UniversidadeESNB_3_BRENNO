package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Carro;
import com.example.universidadeESN3.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> buscarTodos() {
        return carroRepository.findAll();
    }

    public Carro buscarPorId(Long id) {
        Optional<Carro> carro = carroRepository.findById(id);
        return carro.orElse(null);
    }

    public Carro salvar(Carro carro) {
        return carroRepository.save(carro);
    }

    public void atualizar(Carro carro) {
        if (carro.getId() != null && carroRepository.existsById(carro.getId())) {
            carroRepository.save(carro);
        }
    }

    public void excluir(Long id) {
        carroRepository.deleteById(id);
    }
}