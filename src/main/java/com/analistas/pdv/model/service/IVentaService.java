package com.analistas.pdv.model.service;

import java.util.List;

import com.analistas.pdv.model.entities.Venta;

public interface IVentaService {
    
    public List<Venta> buscarTodo();

    public Venta buscarPorId(Long id);

    public void guardar(Venta venta);
    
}
