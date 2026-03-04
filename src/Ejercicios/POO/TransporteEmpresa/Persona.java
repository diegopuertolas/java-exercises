package Ejercicios.POO.TransporteEmpresa;

import Ejercicios.POO.TransporteEmpresa.Exceptions.DatosInvalidosException;
import Ejercicios.POO.TransporteEmpresa.Exceptions.EdadInvalidaException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Persona {

    // Propiedades
    private String m_strNombre;
    private String m_strApellidos;
    private int m_iEdad;

    // Métodos Get
    public String getNombre() {

        return m_strNombre;
    }
    public String getApellidos() { return m_strApellidos; }
    public int getEdad() { return m_iEdad; }

    // Métodos Set
    private void setNombre(String value) throws DatosInvalidosException {
        comprobarDatos(value);
        this.m_strNombre = value;
    }
    private void setApellidos(String value) throws DatosInvalidosException {
        comprobarDatos(value);
        this.m_strApellidos = value;
    }
    private void setEdad(int value) throws EdadInvalidaException {
        if (value < 0) throw new EdadInvalidaException("La edad debe ser mayor que 0.");
        this.m_iEdad = value;
    }

    // Constructor vacío
    // Así podemos crear un objeto vacío para llamar al método cargar datos.
    public Persona() {}

    // Constructor con parámetros
    public Persona(String p_strNombre, String p_strApellidos, int p_iEdad)
            throws EdadInvalidaException, DatosInvalidosException
    {
        setNombre(p_strNombre);
        setApellidos(p_strApellidos);
        setEdad(p_iEdad);
    }

    /**
     * Método para cargar los datos.
     */
    public void cargarDatos() {
        Scanner sc = new Scanner(System.in);

        boolean bNombreValido = false;
        do {
            try {
                System.out.print("Introduzca el nombre: ");
                String strNombre = sc.nextLine();
                setNombre(strNombre);
                bNombreValido = true;
            } catch (DatosInvalidosException die) {
                System.out.println(die.getMessage());
                System.out.println("Inténtelo de nuevo.");
            }
        } while (!bNombreValido);

        boolean bApellidosValido = false;
        do {
            try {
                System.out.print("Introduzca el apellido: ");
                String strApellido = sc.nextLine();
                setApellidos(strApellido);
                bApellidosValido = true;
            } catch (DatosInvalidosException die) {
                System.out.println(die.getMessage());
                System.out.println("Inténtelo de nuevo.");
            }
        } while (!bApellidosValido);

        boolean bEdadValida = false;
        do {
            try {
                int iEdad = leerInt(sc, "Introduzca la edad: ");
                setEdad(iEdad);
                bEdadValida = true;
            } catch (EdadInvalidaException eie) {
                System.out.println(eie.getMessage());
                System.out.println("Inténtelo de nuevo.");
            }
        } while (!bEdadValida);

    }

    /**
     * Método para mostrar los datos por consola.
     */
    public void imprimirDatos() {
        System.out.println("----- DATOS ----");
        System.out.println(this.toString());
    }

    /**
     * Método para comprobar si los datos (Nombre y apellido son correctos)
     * @param strValue String
     * @throws DatosInvalidosException Exception
     */
    private void comprobarDatos(String strValue) throws DatosInvalidosException {
        if (strValue.trim().isEmpty()) throw new DatosInvalidosException("El campo no puede estar vacío.");
    }


    /**
     * Método para leer un int y lanzar excepción en caso de que no lo sea.
     * @param sc Clase Scanner
     * @param strMensaje String
     * @return iDato
     */

    private static int leerInt(Scanner sc, String strMensaje)  {
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

    @Override
    public String toString() {
        return m_strNombre + " " +  m_strApellidos + ", " +  m_iEdad;
    }
}
