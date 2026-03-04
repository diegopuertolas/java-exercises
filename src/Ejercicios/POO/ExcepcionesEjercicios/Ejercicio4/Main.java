package Ejercicios.POO.ExcepcionesEjercicios.Ejercicio4;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Herramientas
    public static Scanner sc = new Scanner(System.in);
    public static Random rn = new Random();

    // Constantes
    public static final int LONGITUD_ARRAY = rn.nextInt(100) + 1;

    public static void main(String[] args) {

        int[] arrNums = new int[LONGITUD_ARRAY];

        for (int i = 0; i < arrNums.length; i++) {
            arrNums[i] = rn.nextInt(10) + 1;
        }

        System.out.println("Array de tamaño: " + LONGITUD_ARRAY);

        boolean bSalir = false;
        do {
            try {

                System.out.print("Introduzca la posición del array que desea consultar: ");
                int iPos = sc.nextInt();

                if (iPos < 0) {
                    bSalir = true;
                    System.out.println("Fin del programa.");
                } else {
                    System.out.println(arrNums[iPos]);
                }

            } catch (InputMismatchException ime) {
                System.out.println("Dato invalido.");
                sc.nextLine();
            } catch (IndexOutOfBoundsException ibe) {
                System.out.println("El número introducido supera la longitud del array.");
            } catch (Exception e) {
                System.out.println("Error inesperado.");
            }
        } while (!bSalir);

    }
}
