package com.analistas.pdv.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.analistas.pdv.model.entities.Venta;
import com.analistas.pdv.model.repository.IVentaRepository;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    IVentaRepository ventaRepository;

    @Override
    public List<Venta> buscarTodo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Venta buscarPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public void guardar(Venta venta) {
        ventaRepository.save(venta);        
    }
    
}
