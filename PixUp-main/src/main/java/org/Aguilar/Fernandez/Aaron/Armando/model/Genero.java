package org.Aguilar.Fernandez.Aaron.Armando.model;

import org.Aguilar.Fernandez.Aaron.Armando.model.negocio.Catalogo;

public class Genero extends Catalogo
{
    private String descripcion;

    public Genero() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Genero='"+descripcion+'\''+
                ", id="+id;
    }
}
