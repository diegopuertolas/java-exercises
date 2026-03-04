package Ejercicios.POO.ExcepcionesEjercicios.Ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca un valor entero: ");

        try {

            int iValor = sc.nextInt();
            System.out.println("Valor introducido: " + iValor);

        } catch (InputMismatchException ime) {
            System.err.println("Valor introducido incorrecto");
        }

    }
}
