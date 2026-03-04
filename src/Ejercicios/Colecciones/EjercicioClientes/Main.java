package Ejercicios.Colecciones.EjercicioClientes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // Herramientas
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Cliente cliente = crearCliente();

        boolean bSalir = false;
        do {
            mostrarMenu();
            int iOpcion = leerInt("Elige una opción: ");

            switch (iOpcion) {
                case 1:
                    addTelefonoOpcion(cliente);
                    break;
                case 2:
                    buscarTelefonoOpcion(cliente);
                    break;
                case 3:
                    System.out.println(cliente);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    bSalir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!bSalir);

    }

    /**
     * Método para crear un cliente con los datos que introduzcamos por Scanner.
     * @return Un objeto de la clase Cliente con los datos introducidos.
     */
    private static Cliente crearCliente() {
        System.out.println("--- CREACIÓN DE CLIENTE ---");
        System.out.print("Introduce el nombre: ");
        String strNombre = sc.nextLine();
        System.out.print("Introduce el email: ");
        String strEmail = sc.nextLine();
        return new Cliente(strNombre, strEmail);
    }

    /**
     * Método para mostrar el menú de opciones por pantalla.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- OPCIONES ---");
        System.out.println("1. Añadir teléfono");
        System.out.println("2. Buscar teléfonos");
        System.out.println("3. Ver información del cliente");
        System.out.println("4. Salir");
    }

    /**
     * Método que solicita un número de teléfono por consola y lo añade al cliente.
     * @param cliente El objeto Cliente al que se le añadirá el teléfono.
     */
    private static void addTelefonoOpcion(Cliente cliente) {
        System.out.print("Introduce el número a añadir: ");
        String strTelefono = sc.nextLine();
        cliente.addTelefono(strTelefono);
    }

    /**
     * Método que solicita una cadena de búsqueda y obtiene los teléfonos coincidentes.
     * @param cliente El objeto Cliente sobre el que se realizará la búsqueda.
     */
    private static void buscarTelefonoOpcion(Cliente cliente) {
        System.out.print("Introduce la cadena a buscar: ");
        String strCadena = sc.nextLine();
        ArrayList<String> arrResultados = cliente.buscarTelefono(strCadena);

        if (arrResultados.isEmpty()) {
            System.out.println("No se encontraron coincidencias.");
        } else {
            System.out.println("Teléfonos encontrados: " + arrResultados);
        }
    }

    /**
     * Método para leer un int y lanzar excepción en caso de que no lo sea.
     * @param strMensaje String
     * @return iDato
     */
    public static int leerInt(String strMensaje)  {
        int iDato = 0;
        boolean bRet = false;
        do {
            try {
                System.out.print(strMensaje);
                iDato = sc.nextInt();
                sc.nextLine();
                bRet = true;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("\nIntroduzca un número entero.");
            }
        } while (!bRet);

        return iDato;
    }
}