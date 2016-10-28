package empresa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dam on 26/10/16.
 */
public class listaPresupuestos {
    private List<presupuesto> listaPresupuestos;
    public listaPresupuestos(){
        listaPresupuestos = new ArrayList<>();
    }

    public List<presupuesto> getListaPresupuestos() {
        return listaPresupuestos;
    }

    public void setListaPresupuestos(List<presupuesto> listaPresupuestos) {
        this.listaPresupuestos = listaPresupuestos;
    }
    public void add(presupuesto presupuesto){
        listaPresupuestos.add(presupuesto);
    }

    @Override
    public String toString() {
        return "" + listaPresupuestos;
    }
}
