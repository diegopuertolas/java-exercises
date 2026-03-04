package Ejercicios.POO.TransporteEmpresa;

import java.util.Scanner;

public class Main {

    // Scanner
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== GESTIÓN DE RUTA ===");

        int iCapacidadBus = 3;
        int iNumParadas = 2;

        Ruta miRuta = new Ruta(iCapacidadBus, iNumParadas);

        String[] arrParadas = {"Madrid", "Barcelona"};
        miRuta.setParadas(arrParadas);


        for (int i = 0; i < iCapacidadBus; i++) {
            System.out.println("\n--- DATOS DEL PASAJERO  ---");

            Empleado empleado = new Empleado();

            empleado.cargarDatos();

            miRuta.subirEmpleado(empleado);
        }

        System.out.println("\n\n=== LISTADO DE PASAJEROS A BORDO ===");

        Empleado[] pasajeros = miRuta.getPasajeros();
        int contador = miRuta.getContadorPasajeros();

        for (int i = 0; i < contador; i++) {
            pasajeros[i].imprimirDatos();
            System.out.println("-------------------------");
        }

        System.out.println("\n=== BAJAR A UN PASAJERO ===");

        System.out.println("Introduzca los datos de la persona que se baja:");
        Empleado empleadoABajar = new Empleado();
        empleadoABajar.cargarDatos();
        miRuta.bajarEmpleado(empleadoABajar);

        System.out.println("\n=== ESTADO FINAL DEL AUTOBÚS ===");
        System.out.println(miRuta.toString());

    }
}