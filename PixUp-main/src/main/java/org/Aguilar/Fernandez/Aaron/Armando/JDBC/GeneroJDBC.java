package org.Aguilar.Fernandez.Aaron.Armando.JDBC;

import org.Aguilar.Fernandez.Aaron.Armando.model.Genero;

import java.util.List;

public interface GeneroJDBC
{

    List<Genero> findAll();
    Genero findById(Integer id);
    boolean save(Genero genero);
    boolean update(Genero genero);
    boolean delete(Genero genero);

}
