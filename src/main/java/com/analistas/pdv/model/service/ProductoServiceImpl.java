package com.analistas.pdv.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.analistas.pdv.model.entities.Producto;
import com.analistas.pdv.model.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

    //Inyección de dependencias (Dependence Injection - DI)
    //Principio de Hollywood (no me llames...yo te llamaré...)
    @Autowired
    IProductoRepository productoRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarTodo() {
        return productoRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarPor(String criterio) {
        return productoRepo.buscarPor(criterio);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto buscarPorId(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void guardar(Producto producto) {
        productoRepo.save(producto);
    }
    
}
