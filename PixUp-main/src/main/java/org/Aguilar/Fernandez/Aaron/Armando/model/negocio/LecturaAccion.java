package org.Aguilar.Fernandez.Aaron.Armando.model.negocio;


import org.Aguilar.Fernandez.Aaron.Armando.ReadUtil.ReadUtil;

public abstract class LecturaAccion implements Ejecutable {
    protected Integer opcion;
    protected boolean flag;

    public LecturaAccion() { flag = true; }

    public abstract void despliegaMenu();
    public abstract int valorMinMenu();
    public abstract int valorMaxMenu();
    public abstract void procesaOpcion();

    @Override
    public void run() {
        while (flag) {
            despliegaMenu();
            opcion = ReadUtil.readInt();
            if ( opcion >= valorMinMenu( ) && opcion <= valorMaxMenu()) {
                if ( opcion == valorMaxMenu()) {
                    flag = false;
                }
                else {
                    procesaOpcion();
                }
            }
        }
    }

    @Override
    public void setFlag(boolean flag) { this.flag = flag; }

    public Integer getOpcion() {return opcion;}

    public void setOpcion(Integer opcion) { this.opcion = opcion; }
}
