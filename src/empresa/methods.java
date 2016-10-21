package empresa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dam on 18/10/16.
 */
public class methods {
    public static void mostrarMenu(){
        System.out.println("1. Alta empresa.cliente");
        System.out.println("2. Nuevo empresa.presupuesto");
        System.out.println("3. Presupuestos pendientes (de aceptar o rechazar)");
        System.out.println("4. Listado de presupuestos de un empresa.cliente determinado");
        System.out.println("5. Listado de presupuestos rechazados");
        System.out.println("6. Listado de clientes");
        System.out.println("7. Cambiar estado de un empresa.presupuesto");
        System.out.println("8. Salir");
    }
    public static void elegirOpcion(){
        mostrarMenu();
        int opcion = pedirEntero("Elige una opción: ");
        do {
            switch (opcion) {
                case 1:
                    altaCliente();
                    break;
                case 2:

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
    public static void altaCliente(){
        String nombre;
        String apellido;
        int telf;
        boolean vip;

        nombre=pedirCadena("Escribe el nombre: ");
        apellido=pedirCadena("Escribe el apellido: ");
        vip=pedirBoolean("Es un cliente vip? (si/no): ");
    }
    public static int comprobarTelf (String mensaje){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int respuesta = 0;
        int aux;
        int cifras;
        boolean error;
        do {
            cifras = 0;
            aux = respuesta;
            try {
                System.out.println(mensaje);
                respuesta = Integer.parseInt(br.readLine());
                while (aux != 0){
                    aux = aux/10;
                    cifras++;
                }
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("No has introducido un nº entero.");
                error = true;
            }
        } while (cifras != 9 || error);
        return respuesta;
    }
    public static String pedirCadena(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String respuesta = "";
        boolean error;
        do {
            try {
                System.out.println(mensaje);
                respuesta = br.readLine();
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida");
                error = true;
            }
        } while (error);
        return respuesta;
    }
    public static Boolean pedirBoolean(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean respuesta = false;
        String aux;
        boolean error;
        do {
            try {
                error = false;
                System.out.println(mensaje);
                aux = br.readLine();
                if (aux.toLowerCase().equals("si")){
                    respuesta = true;
                    break;
                }else if (aux.toLowerCase().equals("no")){
                    respuesta = false;
                    break;
                }else {
                    System.out.println("Respuesta incorrecta, escribe (si/no)");
                    error = true;
                }
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida");
                error = true;
            }
        } while (error);
        return respuesta;
    }
    public static double pedirDouble(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double numero = 0;
        boolean error;
        do {
            try {
                // mostramos el msg para el usuario para pedir dato
                System.out.println(mensaje);
                // Leemos dato del teclado y lo convertimos a entero
                numero = Double.parseDouble(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada y salida");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("No has introducido un nº entero.");
                error = true;
            }
        } while (error);
        return numero;
    }

    public static int pedirEntero(String mensaje) {
        // Variable para leer datos del teclado
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Variable para guardar el nº introducido por el usuario
        int numero = 0;
        // variable para comprobar si ha habido error al introducir el nº
        boolean error;
        do {
            try {
                // mostramos el msg para el usuario para pedir dato
                System.out.println(mensaje);
                // Leemos dato del teclado y lo convertimos a entero
                numero = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada y salida");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("No has introducido un nº entero.");
                error = true;
            }
        } while (error);
        return numero;
    }
}
