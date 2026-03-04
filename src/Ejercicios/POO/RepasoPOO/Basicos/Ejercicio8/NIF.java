package Ejercicios.POO.RepasoPOO.Basicos.Ejercicio8;

public class NIF {

    private static final int LONGITUD_NIF = 8;
    private static final char[] LETRAS_NIF = {
            'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
            'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
    };

    // Propiedades
    private int m_iNumero;
    private char m_cLetras;

    // Métodos Get
    public int getNumero() { return m_iNumero; }
    public char getLetras() { return m_cLetras; }

    // Métodos Set
    private void setNumero(int value) {
        validarNIF(value);

        this.m_iNumero = value;
        this.m_cLetras = calcularLetra(value);
    }

    // Constructor con parámetros
    public NIF(int p_iNumero) {
        setNumero(p_iNumero);
    }

    // Constructor por defecto
    public NIF() {
        this(10000000);
    }

    // Constructor copia
    public NIF(NIF otro) {
        validarObjeto(otro);

        setNumero(otro.getNumero());
    }

    /**
     * Método para validar si un NIF es correcto
     * @param iNumero int
     */
    private static void validarNIF(int iNumero) {
        if (iNumero < 0) throw new IllegalArgumentException("EL DNI no puede ser negativo");
        if (String.valueOf(iNumero).length() != LONGITUD_NIF) throw new IllegalArgumentException("El NIF no tiene la longitud adecuada");
    }

    /**
     * Método para calcular la letra del NIF.
     * @param iNumero inr
     * @return char
     */
    private static char calcularLetra(int iNumero) {
        int iPosicion = iNumero % 23;
        return LETRAS_NIF[iPosicion];
    }

    /**
     * Método para validar si un objeto es nulo, si lo es lanzamos excepción.
     * @param obj
     */
    private static void validarObjeto(Object obj) {
        if (obj == null) throw new IllegalArgumentException("El objeto no puede ser nulo");

    }

    @Override
    public String toString() {
        return m_iNumero + "" + m_cLetras;
    }
}
