package org.Aguilar.Fernandez.Aaron.Armando.JDBC;


import org.Aguilar.Fernandez.Aaron.Armando.model.Disco;

import java.util.List;

public interface DiscoJDBC
{

    List<Disco>findAll();
    Disco findById(Integer id);
    boolean save(Disco disco);
    boolean update(Disco disco);
    boolean delete(Disco disco);

}
