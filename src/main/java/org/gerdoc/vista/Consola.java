package org.gerdoc.vista;

import org.gerdoc.historial.Historiales;
import org.gerdoc.model.figura.Cuadrado;
import org.gerdoc.model.figura.Equilatero;
import org.gerdoc.model.figura.Figura;
import org.gerdoc.model.figura.figura2.Escaleno;
import org.gerdoc.model.figura.figura2.Isosceles;
import org.gerdoc.util.ReadUtil;

public class Consola implements Ejecutable
{
    private static Consola consola;
    private Historiales historiales;

    private Consola()
    {
    }

    public static Consola getInstance( )
    {
        if( consola == null )
        {
            consola = new Consola( );
        }
        return consola;
    }

    @Override
    public void run()
    {
        boolean flag = true;
        int opcion = 0;
        Figura figura = null;
        while( flag )
        {
            figura = null;
            Menu.principal( );
            opcion = ReadUtil.getInstance( ).leerInt( );
            switch( opcion )
            {
                case 1:
                    figura = new Cuadrado( );
                    break;
                case 2:
                    figura = new Equilatero( );
                    break;
                case 3:
                    figura = new Isosceles( );
                    break;
                case 4:
                    figura = new Escaleno( );
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    Menu.opcionInvalida( );
            }
            if( figura != null )
            {
                ((SolicitaDatos)figura).leerDatos( );
                Menu.print( figura );
                historiales.addFigura( figura );
            }
        }
    }

    @Override
    public void addHistoriales(Historiales historiales)
    {
        this.historiales = historiales;
    }
}
