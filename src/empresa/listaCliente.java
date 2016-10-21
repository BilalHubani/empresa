package empresa;

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
    public void altaCliente(cliente cliente){
        listac.add(cliente);
    }
}
