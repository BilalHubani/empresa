package empresa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dam on 11/10/16.
 */
public class cliente {
    private String nombre;
    private String apellido;
    private int telf;
    private boolean vip;
    private listaPresupuestos listaPresupuestos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public empresa.listaPresupuestos getListaPresupuestos() {
        return listaPresupuestos;
    }

    public void setListaPresupuestos(empresa.listaPresupuestos listaPresupuestos) {
        this.listaPresupuestos = listaPresupuestos;
    }

    public void addPresupuesto(presupuesto presupuesto){
        listaPresupuestos.add(presupuesto);
    }
    public cliente() {
    }

    public cliente(String nombre, String apellido, int telf, boolean vip) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telf = telf;
        this.vip = vip;
        this.listaPresupuestos = new listaPresupuestos();
    }

    @Override
    public String toString() {
        return "cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telf=" + telf +
                ", vip=" + vip +
                ", presupuestosCliente=" + listaPresupuestos +
                '}';
    }
}
