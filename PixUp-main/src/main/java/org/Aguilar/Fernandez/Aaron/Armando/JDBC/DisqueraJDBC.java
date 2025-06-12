package org.Aguilar.Fernandez.Aaron.Armando.JDBC;


import org.Aguilar.Fernandez.Aaron.Armando.model.Disquera;

import java.util.List;

public interface DisqueraJDBC
{

        List<Disquera> findAll();
        Disquera findById(Integer id);
        boolean save(Disquera disquera);
        boolean update(Disquera disquera);
        boolean delete(Disquera disquera);

}
