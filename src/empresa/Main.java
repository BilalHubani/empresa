package empresa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dam on 11/10/16.
 */
public class Main {
    private static listaCliente listac;
    private static fichero ficheroClientes;
    public static void main(String[] args) {
        ficheroClientes = new fichero("clientes.xml");
        listac = (listaCliente) ficheroClientes.leer();
        if (listac == null) {
            listac = new listaCliente();
        }
        elegirOpcion();
    }
    public static void altaCliente(){
        String nombre;
        String apellido;
        int telf;
        boolean vip;
        cliente cliente;

        nombre=methods.pedirCadena("Escribe el nombre: ");
        apellido=methods.pedirCadena("Escribe el apellido: ");
        telf=pedirTelf("Escribe el telefono (9 digitos): ");
        vip=methods.pedirBoolean("Es un cliente vip? (si/no): ");
        cliente = new cliente(nombre,apellido,telf,vip);
        listac.addCliente(cliente);
        ficheroClientes.grabar(listac);
    }
    public static int pedirTelf (String mensaje){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int respuesta = 0;
        boolean error;
        boolean comprobar= false;
        do {
            try {
                while (Integer.toString(respuesta).length() != 9) {
                    System.out.println(mensaje);
                    respuesta = Integer.parseInt(br.readLine());
                }
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada /salida");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("No has introducido un nº entero.");
                error = true;
            }
            comprobar = listac.comprobarTelf(respuesta, comprobar);
            if (comprobar == true){
                System.out.println("Numero ya existente, introduce otro");
            }
        } while (error || comprobar);
        return respuesta;
    }
    public static int pedirTelf2 (String mensaje){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int respuesta = 0;
        boolean error;
        boolean comprobar= false;
        do {
            try {
                while (Integer.toString(respuesta).length() != 9) {
                    System.out.println(mensaje);
                    respuesta = Integer.parseInt(br.readLine());
                }
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada/ salida");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("No has introducido un nº entero.");
                error = true;
            }
            comprobar = listac.comprobarTelf(respuesta, comprobar);
            if (comprobar == true){
                altaCliente();
            }
        } while (error);
        return respuesta;
    }
    public static int enteroPresupuesto(String mensaje){
        int respuesta = 0;
        boolean comprobar = true;
        do {
            comprobar=true;
            respuesta = methods.pedirEntero(mensaje);
            for (cliente c: listac.getLista()) {
                for (presupuesto p: c.getListaPresupuestos().getListaPresupuestos()) {
                    if (p.getNum() == respuesta){
                        comprobar = false;
                    }
                }
            }
            if (!comprobar)
                System.out.println("Numero ya existente");
        }while (!comprobar);
        return respuesta;
    }
    public static void nuevoPresupuesto(){
        cliente cliente = null;
        int telf, num;
        String concepto, estado;
        telf = pedirTelf2("Escribe el telefono del cliente del presupuesto que quieres consultar: ");
        num = enteroPresupuesto("Escribe el numero del presupuesto: ");
        concepto = methods.pedirCadena("Escribe el concepto: ");
        estado =
    }
    public static void elegirOpcion(){
        int opcion = 0;
        do {
            methods.mostrarMenu();
            opcion=methods.pedirEntero("Elige una opción: ");
            switch (opcion) {
                case 1:
                    altaCliente();
                    break;
                case 2:
                    nuevoPresupuesto();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    System.out.println("Chao :)");
                    break;
                default:
                    System.out.println("Opción incorrecta!");
                    break;
            }
        }while (opcion != 8);
    }

}
