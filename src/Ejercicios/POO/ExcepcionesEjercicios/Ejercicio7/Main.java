package Ejercicios.POO.ExcepcionesEjercicios.Ejercicio7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final int LONGITUD_ARRAY = 5;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Gato> arrGatos = new ArrayList<>();

        while (arrGatos.size() < LONGITUD_ARRAY) {

            try {

                System.out.println("\r\nDatos para el gato nº" + (arrGatos.size() + 1));

                System.out.print("Nombre: ");
                String strNombre = sc.nextLine();

                System.out.print("Edad: ");
                int iEdad = sc.nextInt();
                sc.nextLine();

                Gato nuevoGato = new Gato(strNombre, iEdad);
                arrGatos.add(nuevoGato);

            } catch (InputMismatchException ime) {
                System.out.println("Dato invalido.");
                sc.nextLine();

            } catch (DatoInvalidoException die) {
                System.out.println(die.getMessage());
            }
        }

        System.out.println("--- RESULTADO ---");
        for (Gato gato : arrGatos) {
            gato.imprimir();
        }

    }
}
