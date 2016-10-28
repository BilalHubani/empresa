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
    public static String pedirEstado(){
        String respuesta;
        do {
            respuesta = methods.pedirCadena("Escribe el estado (aceptado, rechazado, pendiente): ");
        }while(!respuesta.equalsIgnoreCase("aceptado") || !respuesta.equalsIgnoreCase("rechazado") || !respuesta.equalsIgnoreCase("pendiente"));
        return respuesta;
    }
    public static void nuevoPresupuesto(){
        cliente cliente;
        int telf, num;
        String concepto, estado;
        double precio;
        presupuesto presupuesto;
        telf = pedirTelf2("Escribe el telefono del cliente del presupuesto que quieres consultar: ");
        cliente=listac.obtenerClienteTelf(telf);
        num = enteroPresupuesto("Escribe el numero del presupuesto: ");
        concepto = methods.pedirCadena("Escribe el concepto: ");
        estado = pedirEstado();
        precio = methods.pedirDouble("Escribe el precio sin el iva y sin el descuento: ");
        precio = precio*1.21;
        System.out.println("El precio con el iva incluido es: "+ precio);
        if (cliente.isVip()) {
            precio = precio*0.95;
            System.out.println("Como el cliente es vip, se le aplica el descuento: "+ precio);
        }
        presupuesto = new presupuesto(num, concepto, precio,estado);
        cliente.getListaPresupuestos().add(presupuesto);
        ficheroClientes.grabar(listac);
        System.out.println("Presupuesto añadido");
    }
    public static void presupuestosPorEstado(String estado){
        for (cliente cliente: listac.getLista()){
            for (empresa.presupuesto presupuesto: cliente.getListaPresupuestos().getListaPresupuestos()){
                if (presupuesto.getEstado().equalsIgnoreCase(estado)){
                    System.out.println("Cliente : " + cliente.getNombre() +" "+cliente.getApellido()+ " tiene el siguiente presupuesto pendiente: "+ presupuesto);
                }
            }
        }
    }
    public static void presupuestosCliente(){
        int telf = pedirTelf("Escribe el telefono del cliente a consultar: ");
        cliente cliente = listac.obtenerClienteTelf(telf);
        for (presupuesto presupuesto : cliente.getListaPresupuestos().getListaPresupuestos()){
            System.out.println(presupuesto);
        }
    }
    public static void listadoTotal(){
        for (cliente cliente : listac.getLista()){
            System.out.println(cliente);
            for (presupuesto presupuesto : cliente.getListaPresupuestos().getListaPresupuestos()){
                System.out.println(presupuesto);
            }
        }
    }
    public static void cambiarEstado(){
        int num = methods.pedirEntero("Escribe el numero del presupuesto: ");
        boolean exists = false;
        for (cliente cliente : listac.getLista()){
            for (presupuesto presupuesto : cliente.getListaPresupuestos().getListaPresupuestos()){
                if (presupuesto.getNum() == num){
                    exists = true;
                    System.out.println("El estado actual de este presupuesto es: "+ presupuesto.getEstado());
                    presupuesto.setEstado(pedirEstado());
                    break;
                }
            }
        }
        if (!exists){
            System.out.println("No se ha encontrado ningun presupuesto con ese numero");
        }
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
                    // se me guarda el precio total para que no se modifique la factura en caso de que un cliente pase a ser vip
                    nuevoPresupuesto();
                    break;
                case 3:
                    presupuestosPorEstado("pendiente");
                    break;
                case 4:
                    presupuestosCliente();
                    break;
                case 5:
                    presupuestosPorEstado("rechazado");
                    break;
                case 6:
                    listadoTotal();
                    break;
                case 7:
                    cambiarEstado();
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
