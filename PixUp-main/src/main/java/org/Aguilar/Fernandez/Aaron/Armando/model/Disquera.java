package org.Aguilar.Fernandez.Aaron.Armando.model;


import org.Aguilar.Fernandez.Aaron.Armando.model.negocio.Catalogo;

public class Disquera extends Catalogo
{
    private String nombre;

    public Disquera() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Disquera='"+nombre+'\''+
                ", id="+id;
    }
}
