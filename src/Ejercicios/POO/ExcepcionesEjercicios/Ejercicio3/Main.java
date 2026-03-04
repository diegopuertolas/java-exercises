package Ejercicios.POO.ExcepcionesEjercicios.Ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final int LONGITUD_ARRAY = 5;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] arrNums = new double[LONGITUD_ARRAY];

        int iContador = 0;
        do {
            try {

                System.out.print("Introduzca un valor para la posición " + iContador + ": ");
                double dbNum = sc.nextDouble();
                arrNums[iContador] = dbNum;
                iContador++;

            } catch (InputMismatchException ime) {
                System.out.println("Valor incorrecto en la posición " + iContador + ", inténtelo de nuevo.");
                sc.nextLine();
            }

        } while (iContador < arrNums.length);

        System.out.println("\r\n--- Resultado ---");
        for (double num : arrNums) {
            System.out.println(num);
        }

    }
}
