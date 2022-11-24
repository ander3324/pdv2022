package com.analistas.pdv.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.analistas.pdv.model.entities.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
