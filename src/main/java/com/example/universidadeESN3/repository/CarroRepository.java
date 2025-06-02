package com.example.universidadeESN3.repository;

import com.example.universidadeESN3.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}