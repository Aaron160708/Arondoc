package org.Aguilar.Fernandez.Aaron.Armando.model.Catalogo;


import org.Aguilar.Fernandez.Aaron.Armando.JDBC.DiscoJDBC;
import org.Martinez.Bizueto.Mireli.JDBC.*;
import org.Aguilar.Fernandez.Aaron.Armando.JDBC.Impl.ArtistaJDBCImpl;
import org.Aguilar.Fernandez.Aaron.Armando.JDBC.Impl.DiscoJDBCImpl;
import org.Aguilar.Fernandez.Aaron.Armando.JDBC.Impl.DisqueraJDBCImpl;
import org.Aguilar.Fernandez.Aaron.Armando.JDBC.Impl.GeneroJDBCImpl;
import org.Aguilar.Fernandez.Aaron.Armando.ReadUtil.ReadUtil;
import org.Aguilar.Fernandez.Aaron.Armando.model.Artista;
import org.Aguilar.Fernandez.Aaron.Armando.model.Disco;
import org.Aguilar.Fernandez.Aaron.Armando.model.Disquera;
import org.Aguilar.Fernandez.Aaron.Armando.model.Genero;
import org.Aguilar.Fernandez.Aaron.Armando.model.negocio.Catalogos;

import java.util.List;

public class DiscoCatalogo extends Catalogos<Disco>
{
    private static DiscoCatalogo discoCatalogo;
    private static DiscoJDBC discoJDBC;

    public static DiscoCatalogo getInstance()
    {
        if(discoCatalogo==null)
        {
            discoCatalogo=new DiscoCatalogo();
        }
        return discoCatalogo;
    }

    @Override
    public Disco newT() {
        return new Disco();
    }

    @Override
    public boolean processNewT(Disco disco) {
        System.out.println("Teclee el nombre del disco");
        disco.setTitulo(ReadUtil.read());
        System.out.println("Teclee el precio del disco");
        disco.setPrecio(ReadUtil.readFloat());
        System.out.println("Numero de existencia de unidades del disco");
        disco.setExistencia(ReadUtil.readInt());
        System.out.println("Descuento del disco");
        disco.setDescuento(ReadUtil.readFloat());
        System.out.println("Escriba la fecha de lanzamiento del disco");
        disco.setFecha(ReadUtil.readLocalDate());
        System.out.println("Escriba la imagen que posee el disco");
        disco.setImagen(ReadUtil.read());
        boolean flag3=true;
        while (flag3) {
            System.out.println("Escriba el id del artista que hizo el disco");
            int idArtista=ReadUtil.readInt();
            Artista artista= ArtistaJDBCImpl.getInstance().findById(idArtista);
            if(artista!=null)
            {
                disco.setArtista(artista);
                flag3=false;
            }
            else{
                System.out.println("Artista no encontrado");
            }
        }

        flag3=true;
        while (flag3) {
            System.out.println("Escriba el id de la disquera que hizo el disco");
            int idDisquera=ReadUtil.readInt();
            Disquera disquera= DisqueraJDBCImpl.getInstance().findById(idDisquera);
            if(disquera!=null)
            {
                disco.setDisquera(disquera);
                flag3=false;
            }
            else{
                System.out.println("Disquera no encontrada");
            }
        }

        flag3=true;
        while (flag3) {
            System.out.println("Escriba el id del genero al que pertenece el disco");
            int idGenero=ReadUtil.readInt();
            Genero genero= GeneroJDBCImpl.getInstance().findById(idGenero);
            if(genero!=null)
            {
                disco.setGenero(genero);
                flag3=false;
            }
            else{
                System.out.println("Genero no encontrado");
            }
        }
        return true;
    }


    @Override
    public void processEditT(Disco disco)
    {
        System.out.println("Id del disco "+disco.getId());
        System.out.println("Disco a editar: " + disco.getTitulo());
        System.out.println("Teclee el valor nuevo del titulo");
        disco.setTitulo(ReadUtil.read());
        System.out.println("Teclee el nuevo precio del disco");
        disco.setPrecio(ReadUtil.readFloat());
        System.out.println("Nuevo numero de existencia de unidades del disco");
        disco.setExistencia(ReadUtil.readInt());
        System.out.println("Nuevo descuento del disco");
        disco.setDescuento(ReadUtil.readFloat());
        System.out.println("Escriba la nueva fecha de lanzamiento del disco");
        disco.setFecha(ReadUtil.readLocalDate());
        System.out.println("Escriba la nueva imagen que posee el disco");
        disco.setImagen(ReadUtil.read());
        boolean flag3=true;
        while (flag3) {
            System.out.println("Escriba el id del nuevo artista que hizo el disco");
            int idArtista=ReadUtil.readInt();
            Artista artista=ArtistaJDBCImpl.getInstance().findById(idArtista);
            if (artista != null) {
                disco.setArtista(artista);
                flag3=false;
            } else {
                System.out.println("Artista no encontrado");
            }
        }

        flag3=true;
        while (flag3) {
            System.out.println("Escriba el id de la nueva disquera que hizo el disco");
            int idDisquera=ReadUtil.readInt();
            Disquera disquera= DisqueraJDBCImpl.getInstance().findById(idDisquera);
            if(disquera!=null)
            {
                disco.setDisquera(disquera);
                flag3=false;
            }
            else{
                System.out.println("Disquera no encontrada");
            }
        }

        flag3=true;
        while (flag3) {
            System.out.println("Escriba el id del nuevo genero al que pertenece el disco");
            int idGenero=ReadUtil.readInt();
            Genero genero= GeneroJDBCImpl.getInstance().findById(idGenero);
            if(genero!=null)
            {
                disco.setGenero(genero);
                flag3=false;
            }
            else{
                System.out.println("Genero no encontrado");
            }
        }
    }

    @Override
    public List<Disco> processList()
    {
        if(discoJDBC==null)
        {
            if(!loadDiscoJDBC())
            {
                System.out.println("Error al cargar DiscoJDBC");
            }
        }
        return discoJDBC.findAll();
    }

    private boolean loadDiscoJDBC()
    {
        discoJDBC= DiscoJDBCImpl.getInstance();
        return discoJDBC!=null;
    }
}
