package com.analistas.pdv.model.service;

import java.util.List;

import com.analistas.pdv.model.entities.Categoria;

public interface ICategoriaService {
    
    public List<Categoria> buscarTodo();

    public List<Categoria> buscarPor(String criterio);

    public Categoria buscarPorId(Long id);

    public void guardar(Categoria categoria);
}
