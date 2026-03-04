package Ejercicios.POO.ExcepcionesEjercicios.Ejercicio5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean bSalir = false;
        do {
            try {

                System.out.print("Introduzca un número (0 para salir): ");
                int iNum = sc.nextInt();

                if (iNum == 0) {
                    bSalir = true;
                    System.out.println("Fin del programa.");
                } else {

                    System.out.print("Test Positivo: ");
                    try {
                        imprimePositivo(iNum);
                    } catch (IllegalArgumentException iae) {
                        System.out.println("FALLO (" + iae.getMessage() + ")");
                    }

                    System.out.print("Test Negativo: ");
                    try {
                        imprimeNegativo(iNum);
                    } catch (IllegalArgumentException iae) {
                        System.out.println("FALLO (" + iae.getMessage() + ")");

                    }
                }

            } catch (InputMismatchException ime){
                System.out.println("Dato incorrecto.");
                sc.nextLine();
            }

        } while (!bSalir);
    }

    /**
     * Método para imprimir un número entero positivo.
     * @param p {@code int}
     * @throws IllegalArgumentException si el número es negativo.
     */
    public static void imprimePositivo(int p) {
        if (p < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo.");
        }
        System.out.println(p);
    }

    /**
     * Método para imprimir un número entero negativo.
     * @param p {@code int}
     * @throws IllegalArgumentException si el número es positivo o 0.
     */
    public static void imprimeNegativo(int p) {
        if (p >= 0) {
            throw new IllegalArgumentException("El número no puede ser positivo.");
        }
        System.out.println(p);
    }
}
