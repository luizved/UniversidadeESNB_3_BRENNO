package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Moto;
import com.example.universidadeESN3.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> buscarTodos() {
        return motoRepository.findAll();
    }

    public Moto buscarPorId(Long id) {
        Optional<Moto> moto = motoRepository.findById(id);
        return moto.orElse(null);
    }

    public Moto salvar(Moto moto) {
        return motoRepository.save(moto);
    }

    public void atualizar(Moto moto) {
        if (moto.getId() != null && motoRepository.existsById(moto.getId())) {
            motoRepository.save(moto);
        }
    }

    public void excluir(Long id) {
        motoRepository.deleteById(id);
    }
}