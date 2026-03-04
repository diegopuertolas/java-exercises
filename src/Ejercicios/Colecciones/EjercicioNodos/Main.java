package Ejercicios.Colecciones.EjercicioNodos;

import java.util.Scanner;

public class Main {

    // Herramientas
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Lista lista = new Lista();

        System.out.println("Introduce números enteros. Introduce 0 para parar");
        System.out.print("Número: ");
        int n = sc.nextInt();

        while (n != 0) {
            lista.insertar(n);
            System.out.print("Número: ");
            n = sc.nextInt();
        }

        System.out.println("Tu lista ha quedado: ");
        lista.listar();
    }
}
