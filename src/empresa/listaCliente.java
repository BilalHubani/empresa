package empresa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dam on 11/10/16.
 */
public class listaCliente {
    private ArrayList<cliente> listac;
    public listaCliente(){
        listac = new ArrayList<>();
    }

    public ArrayList<cliente> getLista() {
        return listac;
    }

    public void setLista(ArrayList<cliente> lista) {
        this.listac = lista;
    }
    public void addCliente(cliente cliente){
        listac.add(cliente);
    }

    public cliente obtenerClienteTelf(int telf){
        for (cliente cliente: listac){
            if (cliente.getTelf() == telf){
                return cliente;
            }
        }
        return null;
    }
    public Boolean comprobarTelf(int respuesta, boolean comprobar){
        for (cliente cliente : listac) {
            if(cliente.getTelf() == respuesta){
                comprobar = false;
            }
        }
        return comprobar;
    }
}
