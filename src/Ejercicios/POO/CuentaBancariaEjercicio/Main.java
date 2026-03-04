package Ejercicios.POO.CuentaBancariaEjercicio;

import Ejercicios.POO.CuentaBancariaEjercicio.Types.*;
import Ejercicios.POO.CuentaBancariaEjercicio.Exceptions.*;
import java.util.InputMismatchException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("--- SISTEMA BANCARIO ---");


        Titular titular = null;
        boolean bTitularValido = false;

        do {
            try {
                System.out.print("Nombre del titular: ");
                String strNombre = sc.nextLine();
                System.out.print("Apellidos del titular: ");
                String strApellidos = sc.nextLine();

                titular = new Titular(strNombre, strApellidos);
                System.out.println("\nTitular creado.");
                bTitularValido = true;
            } catch (TitularInvalidoException die) {
                System.out.println(die.getMessage());
                System.out.println("Inténtelo de nuevo.");
            }
        } while (!bTitularValido);


        IBAN iban = null;
        boolean bIBANValido = false;

        do {
            try {
                System.out.print("\nIntroduzca su IBAN: ");
                String strIBANCompleto = sc.nextLine();
                iban = new IBAN(strIBANCompleto);
                bIBANValido = true;
            } catch (IBANInvalidoException iie) {
                System.out.println(iie.getMessage());
                System.out.println("Inténtelo de nuevo.");
            }
        } while(!bIBANValido);

        System.out.println("\nCreando Cuenta Bancaria...");
        CuentaBancaria cuentaBancaria = new CuentaBancaria(titular, iban);

        System.out.println("Cuenta Bancaria creada correctamente.");

        // MENU
        boolean bSalir = false;
        while (!bSalir) {

                System.out.println("\n1. Datos de la Cuenta");
                System.out.println("2. Ingresar Dinero");
                System.out.println("3. Retirar Dinero");
                System.out.println("4. Mostrar Saldo");
                System.out.println("5. Mostrar Titular");
                System.out.println("6. Mostrar IBAN");
                System.out.println("7. Listar Movimientos");
                System.out.println("8. Salir ");

                int iOpcion = leerInt(sc, "\nIntroduzca un número del 1 al 8: ");

                switch (iOpcion) {
                    case 1:
                        cuentaBancaria.imprimirDatos();
                        break;
                    case 2:
                        try {
                            double dbCantidadIngreso = leerDouble(sc, "\nIntroduzca la cantidad a ingresar: " );

                            System.out.print("Introduzca el concepto del ingreso: ");
                            String strConceptoIngreso = sc.nextLine();

                            System.out.print("Introduzca al ordenante del ingreso: ");
                            String strOrdenanteIngreso = sc.nextLine();

                            System.out.print("Introduzca la fecha del ingreso: ");
                            String strFechaIngreso = sc.nextLine();

                            cuentaBancaria.ingresarDinero(strFechaIngreso, dbCantidadIngreso, strConceptoIngreso, strOrdenanteIngreso);
                        } catch (MovimientoInvalidoException mie) {
                            System.out.println(mie.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            double dbCantidadRetiro = leerDouble(sc, "\nIntroduzca la cantidad a retirar: " );

                            System.out.print("Introduzca el concepto del retiro: ");
                            String strConceptoRetiro = sc.nextLine();

                            System.out.print("Introduzca al ordenante del retiro: ");
                            String strOrdenanteRetiro = sc.nextLine();

                            System.out.print("Introduzca la fecha del retiro: ");
                            String strFechaRetiro = sc.nextLine();

                            cuentaBancaria.retirarDinero(strFechaRetiro, dbCantidadRetiro, strConceptoRetiro, strOrdenanteRetiro);
                        } catch (MovimientoInvalidoException mie) {
                            System.out.println(mie.getMessage());
                        } catch (SaldoInsuficienteException sie) {
                            System.out.println(sie.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("\nEl saldo de su cuenta es de " + cuentaBancaria.getSaldo() + "€.\n");
                        break;
                    case 5:
                        System.out.println("\nEl titular de la cuenta es: " + cuentaBancaria.getTitular() + ".\n");
                        break;
                    case 6:
                        System.out.println("\nIBAN: " + cuentaBancaria.getIBAN() + ".\n");
                        break;
                    case 7:
                        System.out.println("\n--- Lista de Movimientos ---");
                        cuentaBancaria.listarMovimientos();
                        break;
                    case 8:
                        System.out.println("\nSaliendo del programa...");
                        bSalir = true;
                        break;
                    default:
                        System.out.println("\nOpción no válida (" + iOpcion + "). Elija entre 1 y 8.");
                }
        }
    }

    /**
     * Método para leer un double y lanzar excepción en caso de que no lo sea.
     * @param sc Clase Scanner
     * @param strMensaje String
     * @return dbDato
     */
    public static double leerDouble (Scanner sc, String strMensaje) {
        double dbDato = 0;
        boolean bRet = false;

        do {
            try {
                System.out.println(strMensaje);
                dbDato = sc.nextDouble();
                sc.nextLine();
                bRet = true;
            } catch (InputMismatchException e) {
                System.out.print("\nIntroduzca un número decimal.");
                sc.nextLine();
            }
        } while (!bRet);

        return dbDato;
    }

    /**
     * Método para leer un int y lanzar excepción en caso de que no lo sea.
     * @param sc Clase Scanner
     * @param strMensaje String
     * @return iDato
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
