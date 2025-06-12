package org.Aguilar.Fernandez.Aaron.Armando.JDBC;

import org.Aguilar.Fernandez.Aaron.Armando.model.Artista;

import java.util.List;

public interface ArtistaJDBC
{
    List<Artista> findAll();
    Artista findById(Integer id);
    boolean save(Artista artista);
    boolean update(Artista artista);
    boolean delete(Artista artista);
}
