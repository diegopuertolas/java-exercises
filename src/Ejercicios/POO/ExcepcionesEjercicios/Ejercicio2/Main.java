package Ejercicios.POO.ExcepcionesEjercicios.Ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Introduzca un primer número: ");
            int iNum1 = sc.nextInt();

            System.out.print("Introduzca un segundo número: ");
            int iNum2 = sc.nextInt();

            int iOperacion = iNum1 / iNum2;
            System.out.println("Resultado: " + iOperacion);

        } catch (InputMismatchException ime) {
            System.err.println("Valor introducido incorrecto");
        } catch (ArithmeticException ae) {
            System.err.println("Operación incorrecta.");
        }

    }
}
