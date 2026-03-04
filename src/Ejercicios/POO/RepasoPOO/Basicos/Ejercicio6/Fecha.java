package Ejercicios.POO.RepasoPOO.Basicos.Ejercicio6;

public class Fecha {

    // Propiedades
    private int m_iDia;
    private int m_iMes;
    private int m_iYear;

    // Métodos Get
    public int getDia() { return m_iDia; }
    public int getMes() { return m_iMes; }
    public int getYear() { return m_iYear; }

    // Métodos Set
    private void setDia(int value) { this.m_iDia = value; }
    private void setMes(int value) { this.m_iMes = value;}

    private void setYear(int value) { this.m_iYear = value; }

    // Constructor con parámetros
    public Fecha(int p_iDia, int p_iMes, int p_iYear) {
        validarFecha(p_iDia, p_iMes, p_iYear);

        setDia(p_iDia);
        setMes(p_iMes);
        setYear(p_iYear);
    }

    // Constructor por defecto
    public Fecha() {
        this(1,1, 1);
    }

    // Constructor copia
    public Fecha(Fecha otro) {
        validarObjeto(otro);

        setDia(otro.getDia());
        setMes(otro.getMes());
        setYear(otro.getYear());
    }

    /**
     * Método para obtener la fecha del dia siguiente a una fecha dada.
     * @return Objeto de la Clase Fecha
     */
    public Fecha diaSiguiente() {

        int iNuevoDia = m_iDia + 1;
        int iNuevoMes = m_iMes;
        int iNuevoYear = m_iYear;

        int iMaxDias = obtenerMaxDias(m_iMes, m_iYear);

        if (iNuevoDia > iMaxDias) {
            iNuevoDia = 1;
            iNuevoMes++;

            if (iNuevoMes > 12) {
                iNuevoMes = 1;
                iNuevoYear++;
            }
        }

        return new Fecha(iNuevoDia, iNuevoMes, iNuevoYear);
    }

    /**
     * Método para comprobar si una fecha es correcta
     * @return true / false
     */
    public boolean esFechaCorrecta() {
        boolean bEsCorrecta = true;

        try {
            validarFecha(m_iDia, m_iMes, m_iYear);
        } catch (Exception e) {
            bEsCorrecta = false;
        }

        return bEsCorrecta;
    }

    /**
     * Método para validar una fecha, si no es válida lanzamos una excepción
     * @param iDia int
     * @param iMes int
     * @param iYear int
     */
    private void validarFecha(int iDia, int iMes, int iYear) {
        // Validamos el mes
        if (iMes < 1 || iMes > 12) throw new IllegalArgumentException("Mes incorrecto: " + iMes);

        // Validamos el año
        if (iYear < 0) throw new IllegalArgumentException("El año no puede ser negativo");

        // Validamos el número de días
        int iMaxDias = obtenerMaxDias(iMes, iYear);
        if (iDia < 1 || iDia > iMaxDias) throw new IllegalArgumentException("Dia incorrecto");
    }

    /**
     * Método para obtener el máximo de días de un mes y año dados.
     * @param iMes int
     * @param iYear int
     * @return int
     */
    private static int obtenerMaxDias(int iMes, int iYear) {
        int iDias = 0;

        switch (iMes) {
            case 2:
                if (esBisiesto(iYear)) iDias = 29;
                iDias = 28;
                break;
            case 4, 6, 9, 11:
                iDias = 30;
                break;
            case 1, 3, 5, 7, 8, 10, 12:
                iDias = 31;
                break;
            default:
                throw new IllegalArgumentException("Mes incorrecto: " + iMes);
        }

        return iDias;
    }

    /**
     * Método para comprobar si un año es bisiesto
     * @param iYear int
     * @return true / false
     */
    private static boolean esBisiesto(int iYear) {
        return (iYear % 4 == 0 && iYear % 100 != 0) || (iYear % 400 == 0);
    }


    // Métodos Auxiliares
    private static void validarObjeto(Object obj) {
        if (obj == null) throw new IllegalArgumentException("El objeto no puede ser nulo.");
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", m_iDia, m_iMes, m_iYear);
    }
}
