package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.coche;

public interface cocheRepositorio extends JpaRepository<coche, Long> {

}
