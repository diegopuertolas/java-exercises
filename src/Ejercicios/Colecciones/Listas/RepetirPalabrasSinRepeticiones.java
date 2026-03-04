package Ejercicios.Colecciones.Listas;

import java.util.ArrayList;
import java.util.Scanner;

public class RepetirPalabrasSinRepeticiones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> palabras = new ArrayList<>();

        boolean bSalir = false;
        do {
            System.out.print("Introduzca una palabra, FIN para salir: ");
            String strPalabra = sc.nextLine();
            if (strPalabra.toLowerCase().equalsIgnoreCase("FIN")) {
                bSalir = true;
            } else if (!palabras.contains(strPalabra)) {
                palabras.add(strPalabra);
            }
        } while (!bSalir);

        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }
}
