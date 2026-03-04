package Ejercicios.POO.ComparableComparator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Persona[] p = new Persona[] {
                new Persona(3, "Diego", 19),
                new Persona(1, "Canelina", 20),
                new Persona(6, "MT", 12)
        };

        // Ordenar el Array:
        Arrays.sort(p);

        // Devuelve el Array en forma de String.
        System.out.println(Arrays.deepToString(p));

        ComparadorPersonas c = new ComparadorPersonas();

        Arrays.sort(p, c);
        System.out.println(Arrays.deepToString(p));
    }
}
