package com.analistas.pdv.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.analistas.pdv.model.entities.Categoria;
import com.analistas.pdv.model.repository.ICategoriaRepository;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    ICategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> buscarTodo() {
        return categoriaRepository.findAll();
    }

    @Override
    public List<Categoria> buscarPor(String criterio) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Categoria categoria) {
        // TODO Auto-generated method stub
        
    }
    
}
