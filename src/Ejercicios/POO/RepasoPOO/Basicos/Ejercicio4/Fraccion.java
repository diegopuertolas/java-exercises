package Ejercicios.POO.RepasoPOO.Basicos.Ejercicio4;

public class Fraccion {

    // Propiedades
    private int m_iNumerador;
    private int m_iDenominador;

    // Métodos Get
    public int getNumerador() { return m_iNumerador; }
    public int getDenominador() { return m_iDenominador; }

    // Métodos Set
    private void setNumerador(int value) {
        this.m_iNumerador = value;
    }

    private void setDenominador(int value) {
        validarNumero(value);
        this.m_iDenominador = value;
    }

    // Constructor con parámetros
    public Fraccion(int p_iNumerador, int p_iDenominador) {
        setNumerador(p_iNumerador);
        setDenominador(p_iDenominador);
    }

    // Constructor por defecto
    public Fraccion() {
        this(0, 1);
    }

    // Constructor copia
    public Fraccion(Fraccion otro) {
        validarObjeto(otro);
        setNumerador(otro.getNumerador());
        setDenominador(otro.getDenominador());
    }

    /**
     * Método para sumar fracciones
     * @param otra Clase Fraccion
     */
    public Fraccion sumarFraccion(Fraccion otra) {
        validarObjeto(otra);

        int iNuevoDenominador = mcm(this.m_iDenominador, otra.getDenominador());

        int iNum1Ajustado = (iNuevoDenominador / this.m_iDenominador) * this.m_iNumerador;
        int iNum2Ajustado = (iNuevoDenominador / otra.getDenominador()) * otra.getNumerador();

        int iNuevoNumerador = iNum1Ajustado + iNum2Ajustado;

        Fraccion resultado =  new Fraccion(iNuevoNumerador, iNuevoDenominador);

        resultado.simplificar();

        return resultado;
    }

    /**
     * Método para restar fracciones
     * @param otra Clase Fraccion
     */
    public Fraccion restarFracciones(Fraccion otra) {
        validarObjeto(otra);

        int iNuevoDenominador = mcm(this.m_iDenominador, otra.getDenominador());

        int iNum1Ajustado = (iNuevoDenominador / this.m_iDenominador) * this.m_iNumerador;
        int iNum2Ajustado = (iNuevoDenominador / otra.getDenominador()) * otra.getNumerador();

        int iNuevoNumerador = iNum1Ajustado - iNum2Ajustado;

        Fraccion resultado =  new Fraccion(iNuevoNumerador, iNuevoDenominador);

        resultado.simplificar();

        return resultado;
    }

    /**
     * Método para multiplicar fracciones.
     * @param otra Clase Fraccion
     */
    public Fraccion multiplicarFracciones(Fraccion otra) {
        validarObjeto(otra);

        int iNuevoNumerador = this.m_iNumerador * otra.getNumerador();
        int iNuevoDenominador = this.m_iDenominador * otra.getDenominador();

        Fraccion resultado =  new Fraccion(iNuevoNumerador, iNuevoDenominador);

        resultado.simplificar();

        return resultado;
    }

    /**
     * Método para dividir fracciones.
     * @param otra Clase Fraccion
     */
    public Fraccion dividirFracciones(Fraccion otra) {
        validarObjeto(otra);

        // Validamos que no estemos dividiendo por una fracción con numerador 0.
        if (otra.getNumerador() == 0) {
            throw new IllegalArgumentException("No se puede dividir por una fracción con valor 0");
        }

        int iNumerador = this.m_iNumerador * otra.getDenominador();
        int iDenominador = this.m_iDenominador * otra.getNumerador();

        Fraccion resultado =  new Fraccion(iNumerador, iDenominador);

        resultado.simplificar();

        return resultado;
    }

    /**
     * Método para calcular el máximo común divisor.
     * Seguimos el Algoritmo de Euclides.
     * @param iNum1 int
     * @param iNum2 int
     * @return int
     */
    private static int mcd(int iNum1, int iNum2) {
        while (iNum2 != 0) {
            int iTemp = iNum2;
            iNum2 = iNum1 % iNum2;
            iNum1 = iTemp;
        }
        return iNum1;
    }

    /**
     * Método para calcular el mínimo común múltiplo.
     * mcm(a,b) = |a*b| / mcd(a, b)
     * @param iNum1 int
     * @param iNum2 int
     * @return int
     */
    private static int mcm(int iNum1, int iNum2) {
        int iMcm;
        iMcm = Math.abs(iNum1 * iNum2) / mcd(iNum1, iNum2);
        return iMcm;
    }

    public void simplificar() {
        int iDivisorComun = mcd(m_iNumerador, m_iDenominador);
        m_iNumerador /= iDivisorComun;
        m_iDenominador /= iDivisorComun;

        if (m_iDenominador < 0) {
            m_iNumerador = -m_iNumerador;
            m_iDenominador = -m_iDenominador;
        }
    }

    /**
     * Método para validar si un objeto es nulo, si lo es lanzamos una excepción.
     * @param obj Clase Object
     */
    private static void validarObjeto(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("El objeto no puede ser nulo");
        }
    }

    private static void validarNumero(int iValor) {
        if (iValor == 0) {
            throw new IllegalArgumentException("El número no puede ser 0");
        }
    }

    @Override
    public String toString() {
        if (m_iDenominador == 1) {
            return "" + m_iNumerador;
        }
        return m_iNumerador + "/" + m_iDenominador;
    }
}