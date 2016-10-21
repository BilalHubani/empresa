package empresa;

import java.util.ArrayList;

/**
 * Created by dam on 11/10/16.
 */
public class listaPresupuesto {
    private ArrayList<cliente> listap;
    public listaPresupuesto(){
        listap = new ArrayList<>();
    }

    public ArrayList<cliente> getListap() {
        return listap;
    }

    public void setListap(ArrayList<cliente> listap) {
        this.listap = listap;
    }
}
