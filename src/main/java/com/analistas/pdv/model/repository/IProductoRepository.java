package com.analistas.pdv.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.analistas.pdv.model.entities.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
    
    //JPQL: Java Persistence Query Language
    //HQL: Hibernate Query Language
    //Equivalente en SQL: 
    //select * from productos where cod_bar like ? or descripcion like ? and act = 1
    @Query("select p from Producto p where p.codigoBarras  like %:criterio% or p.descripcion like %:criterio% and p.activo = true")
    List<Producto> buscarPor(@Param("criterio") String criterio);

    @Query("select p from Producto p where  p.activo = true")
    List<Producto> buscarSoloHabilitados();
}
