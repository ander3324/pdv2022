package com.analistas.pdv.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.analistas.pdv.model.entities.Venta;

public interface IVentaRepository  extends JpaRepository <Venta, Long>{
    
}
