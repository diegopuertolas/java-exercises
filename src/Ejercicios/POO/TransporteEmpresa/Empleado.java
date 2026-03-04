package Ejercicios.POO.TransporteEmpresa;

import Ejercicios.POO.TransporteEmpresa.Exceptions.DatosInvalidosException;
import Ejercicios.POO.TransporteEmpresa.Exceptions.EdadInvalidaException;
import Ejercicios.POO.TransporteEmpresa.Exceptions.SueldoInvalidoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Empleado extends Persona {

    // Propiedades,
    private double m_dbSueldo;

    // Métodos Get y Set
    public double getSueldo() { return m_dbSueldo; }

    private void setSueldo(double value) throws SueldoInvalidoException {
        if (value < 0) throw new SueldoInvalidoException("El sueldo debe ser mayor que 0");
        this.m_dbSueldo = value;
    }

    // Constructor vacío
    // Así podemos crear un objeto vacío para llamar al método cargar datos y cargar sueldo.
    public Empleado() {}

    // Constructor con parámetros
    public Empleado(String p_strNombre, String p_strApellidos, int p_iEdad, double p_dbSueldo) throws SueldoInvalidoException, EdadInvalidaException, DatosInvalidosException {
        super(p_strNombre, p_strApellidos, p_iEdad);
        setSueldo(p_dbSueldo);
    }

    /**
     * Método para cargar el suelo del empleado
     */
    public void cargarSueldo()  {
        Scanner sc = new Scanner(System.in);

        boolean bSueldoValido = false;
        do {
            try {
                double dbSueldo = leerDouble(sc, "Introduzca el sueldo: ");
                setSueldo(dbSueldo);
                bSueldoValido = true;
            } catch (SueldoInvalidoException sie) {
                System.out.println(sie.getMessage());
                System.out.println("Inténtelo de nuevo");
            }
        } while (!bSueldoValido);
    }

    public void imprimirSueldo() {
        System.out.println("----- SUELDO -----");
        System.out.println(this.m_dbSueldo);
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
                System.out.print(strMensaje);
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
     * Sobreescribimos el método cargarDatos, heredado de Persona para que un empleado
     * cuando acceda a este método deba también introducir el sueldo.
     */
    @Override
    public void cargarDatos() {
        super.cargarDatos();
        this.cargarSueldo();
    }

    @Override
    public String toString() {
        return "Datos: " + getNombre() + " " + getApellidos() +  ", Edad: " + getEdad() + " | Sueldo: " + m_dbSueldo;
    }
}
