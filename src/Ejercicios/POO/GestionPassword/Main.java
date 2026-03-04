package Ejercicios.POO.GestionPassword;

import Ejercicios.POO.GestionPassword.Exceptions.LongitudInvalidaException;
import java.util.InputMismatchException;

import java.util.Scanner;

public class Main {

    // Herramientas
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Password[] arrPasswords = null;
        boolean[] arrBooleans = null;
        int iLongitudArray = 0;
        int iLongitudPassword = 0;

        boolean bLongitudesValidas = false;
        do {
            try {
                iLongitudArray = leerInt(sc, "Introduzca el número de contraseñas que desea introducir: ");

                if (iLongitudArray <= 0) throw new LongitudInvalidaException("El número de contraseñas debe ser mayor que 0.");

                iLongitudPassword = leerInt(sc, "Introduzca la longitud de las contraseñas: ");

                // Creamos un objeto de prueba de la clase Contraseña para verificar si la longitud es valida.
                new Password(iLongitudPassword);

                arrPasswords = new Password[iLongitudArray];
                arrBooleans = new boolean[iLongitudArray];

                bLongitudesValidas = true;

            } catch (LongitudInvalidaException lie) {
                System.out.println(lie.getMessage());
                System.out.println("Inténtelo de nuevo.");
            }
        } while (!bLongitudesValidas);

        try {
            for (int i = 0; i < arrPasswords.length; i++) {
                arrPasswords[i] = new Password(iLongitudPassword);
                arrBooleans[i] = arrPasswords[i].esFuerte();

            }

        } catch (LongitudInvalidaException lie) {
            System.out.println("ERROR INESPERADO");
        }


        // Imprimimos resultados
        System.out.println("----- RESULTADOS -----");
        for (int i = 0; i < arrPasswords.length; i++) {
            System.out.println(arrPasswords[i] + " | " + arrBooleans[i]);
        }

    }

    /**
     * Método para leer un int y lanzar excepción en caso de que no lo sea.
     * @param sc Clase Scanner
     * @param strMensaje String
     * @return int
     */
    public static int leerInt(Scanner sc, String strMensaje)  {
        int iDato = 0;
        boolean bRet = false;

        do {
            try {
                System.out.print(strMensaje);
                iDato = sc.nextInt();
                sc.nextLine();
                bRet = true;
            } catch (InputMismatchException e) {
                System.out.println("\nIntroduzca un número entero.");
                sc.nextLine();
            }
        } while (!bRet);

        return iDato;
    }
}
