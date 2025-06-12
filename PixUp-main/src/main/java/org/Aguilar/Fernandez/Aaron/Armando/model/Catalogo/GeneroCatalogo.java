package org.Aguilar.Fernandez.Aaron.Armando.model.Catalogo;

import org.Aguilar.Fernandez.Aaron.Armando.JDBC.GeneroJDBC;
import org.Aguilar.Fernandez.Aaron.Armando.JDBC.Impl.GeneroJDBCImpl;
import org.Aguilar.Fernandez.Aaron.Armando.ReadUtil.ReadUtil;
import org.Aguilar.Fernandez.Aaron.Armando.model.Genero;
import org.Aguilar.Fernandez.Aaron.Armando.model.negocio.Catalogos;

import java.util.List;

public class GeneroCatalogo extends Catalogos<Genero>
{
    private static GeneroCatalogo generoCatalogo;
    private static GeneroJDBC generoJDBC;

    public static GeneroCatalogo getInstance()
    {
        if(generoCatalogo==null)
        {
            generoCatalogo=new GeneroCatalogo();
        }
        return generoCatalogo;
    }

    @Override
    public Genero newT() {
        return new Genero();
    }

    @Override
    public boolean processNewT(Genero genero) {
        System.out.println("Teclee un genero");
        genero.setDescripcion(ReadUtil.read());
        return true;
    }

    @Override
    public void processEditT(Genero genero)
    {
        System.out.println("-------------------");
        System.out.println("Id del genero "+genero.getId());
        System.out.println("Genero a editar: " + genero.getDescripcion());
        System.out.println("Teclee el valor nuevo del genero");
        System.out.println("-------------------");
        genero.setDescripcion(ReadUtil.read());
    }

    @Override
    public List<Genero> processList()
    {
        if(generoJDBC==null)
        {
            if(!loadGeneroJDBC())
            {
                System.out.println("Error al cargar GeneroJDBC");
            }
        }
        return generoJDBC.findAll();
    }

    private boolean loadGeneroJDBC()
    {
        generoJDBC= GeneroJDBCImpl.getInstance();
        return generoJDBC!=null;
    }
}
