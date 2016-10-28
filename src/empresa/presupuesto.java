package empresa;

/**
 * Created by dam on 11/10/16.
 */
public class presupuesto{
    private int num;
    private String  concepto;
    private double ptotal;
    private String estado;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getPtotal() {
        return ptotal;
    }

    public void setPtotal(double ptotal) {
        this.ptotal = ptotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public presupuesto(int num, String concepto, double ptotal, String estado) {
        this.num = num;
        this.concepto = concepto;
        this.ptotal = ptotal;
        this.estado = estado;
    }

    public presupuesto() {
    }

    @Override
    public String toString() {
        return "presupuesto{" +
                "num=" + num +
                ", concepto='" + concepto + '\'' +
                ", ptotal=" + ptotal +
                ", estado='" + estado + '\'' +
                '}';
    }
}
