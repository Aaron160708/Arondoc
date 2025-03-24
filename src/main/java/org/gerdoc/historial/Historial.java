package org.gerdoc.historial;

import org.gerdoc.model.figura.Figura;

import java.util.ArrayList;
import java.util.List;

public class Historial implements Historiales
{
    private static Historial historial;
    private List<Figura> list;

    private Historial()
    {
    }

    public static Historial getInstance( )
    {
        if( historial == null )
        {
            historial = new Historial( );
        }
        return historial;
    }

    @Override
    public void addFigura( Figura figura)
    {
        if( list == null)
        {
            list = new ArrayList<Figura>();
        }
        list.add( figura );
    }

    @Override
    public void imprimir( )
    {
        if( list == null || list.isEmpty() )
        {
            System.out.println( "Historial vacio");
            return;
        }
        System.out.println( "entre");
        list.forEach( (p ) -> {
            System.out.println( p.area() );
            System.out.println( p.perimetro() );
        } );
        System.out.println( "sali");
/*
        for( int i = 0; i < list.size(); i++ )
        {
            System.out.println( list.get( i ) );
            list.get( i ).area();
            list.get( i ).perimetro();
        }

 */
    }

}
