package com.analistas.pdv.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre de usuario es requerido...")
    @Size(max = 30, min = 5)
    private String nombre;

    @NotEmpty(message = "La contraseña es obligatoria...")
    @Size(max = 70, min = 6, message = "La contraseña de contener al menos 6 caracteres...")
    private String clave;

    @Column(name = "activo", columnDefinition = "boolean default 1")
    private boolean activo;

    @NotNull(message = "El permiso es obligatorio...")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_permiso", referencedColumnName = "id")
    private Permiso permiso;

    public Usuario() {
        activo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    @Override
    public String toString() {
        return nombre + " [" + permiso.getNombre() + "]";
    }
}
