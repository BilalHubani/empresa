package empresa;

/**
 * Created by dam on 11/10/16.
 */
public class cliente {
    private String nombre;
    private String apellido;
    private int telf;
    private boolean vip;

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

    public cliente(String nombre, String apellido, int telf, boolean vip) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telf = telf;
        this.vip = vip;
    }
}
