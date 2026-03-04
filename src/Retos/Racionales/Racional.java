package Retos.Racionales;

public class Racional {

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

    private void setDenominador(int value) throws DatoInvalidoException {
        validarNumero(value);
        this.m_iDenominador = value;
    }

    /**
     * Constructor completo.
     * Creamos un racional y lo simplificamos si es posible.
     * @param p_iNumerador El numerador.
     * @param p_iDenominador El denominador (no puede ser 0).
     * @throws DatoInvalidoException() Si el denominador es 0.
     */
    public Racional(int p_iNumerador, int p_iDenominador) throws DatoInvalidoException {
        setNumerador(p_iNumerador);
        setDenominador(p_iDenominador);
        simpl();
    }

    /**
     * Constructor para números enteros
     * Convertimos un entero 'n' a la fracción 'n/1'
     *
     * @param p_iNumerador El número entero
     */
    public Racional(int p_iNumerador) throws DatoInvalidoException {
        setNumerador(p_iNumerador);
        setDenominador(1);
    }

    /**
     * Constructor por defecto
     */
    public Racional() throws DatoInvalidoException {
        this(0, 1);
    }

    /**
     * Constructor de copia.
     *
     * @param otro El objeto Racional a copiar.
     * @throws DatoInvalidoException() Si el objeto pasado es nulo.
     */
    public Racional(Racional otro) throws DatoInvalidoException {
        validarObjeto(otro);
        setNumerador(otro.getNumerador());
        setDenominador(otro.getDenominador());
    }

    /**
     * Método para sumar el racional actual entre otro.
     *
     * <p>
     * {@code (a*d + c*b) / (b*d)}
     * El resultado se simplifica y se almacena en el objeto actual.
     * </p>
     *
     * @param otro El racional a sumar.
     * @throws DatoInvalidoException() Si el parámetro es nulo.
     */
    public void sum(Racional otro) throws DatoInvalidoException {
        validarObjeto(otro);

        int iNuevoNumerador = (this.m_iNumerador * otro.getDenominador()) + (otro.getNumerador() * this.m_iDenominador);
        int iNuevoDenominador = this.m_iDenominador * otro.getDenominador();

        this.m_iNumerador = iNuevoNumerador;
        this.m_iDenominador = iNuevoDenominador;

        simpl();
    }

    /**
     * Método para restar el racional actual con otro.
     *
     * <p>
     * {@code (a*d - c*b) / (b*d)}
     * El resultado se simplifica y se almacena en el objeto actual.
     * </p>
     *
     * @param otro El racional a restar.
     * @throws DatoInvalidoException() Si el parámetro es nulo.
     */
    public void res(Racional otro) throws DatoInvalidoException {
        validarObjeto(otro);

        int iNuevoNumerador = (this.m_iNumerador * otro.getDenominador()) - (otro.getNumerador() * this.m_iDenominador);
        int iNuevoDenominador = this.m_iDenominador * otro.getDenominador();

        this.m_iNumerador = iNuevoNumerador;
        this.m_iDenominador = iNuevoDenominador;

        simpl();
    }

    /**
     * Método para multiplicar el racional actual por otro.
     *
     * <p>
     * {@code (a*c) / (b*d)}
     * El resultado se simplifica y se almacena en el objeto actual.
     * </p>
     *
     * @param otro El racional multiplicador.
     * @throws DatoInvalidoException() Si el parámetro es nulo.
     */
    public void mul(Racional otro) throws DatoInvalidoException {
        validarObjeto(otro);

        this.m_iNumerador *= otro.getNumerador();
        this.m_iDenominador *= otro.getDenominador();

        simpl();
    }

    /**
     * Método para dividir el racional actual entre otro.
     *
     * <p>
     * {@code (a*d) / (b*c)}
     * El resultado se simplifica y se almacena en el objeto actual.
     * </p>
     *
     * @param otro El racional divisor.
     * @throws DatoInvalidoException() Si el parámetro es nulo.
     * @throws ArithmeticException Sí se intenta dividir por una fracción con el numerador 0.
     */
    public void div(Racional otro) throws DatoInvalidoException {
        validarObjeto(otro);

        // Validamos que no estemos dividiendo por una fracción con numerador 0.
        if (otro.getNumerador() == 0) { throw new ArithmeticException("No se puede dividir por 0"); }

        this.m_iNumerador *= otro.getDenominador();
        this.m_iDenominador *= otro.getNumerador();

        simpl();
    }

    /**
     * Método para simplificar.
     *
     * <p>
     * Utilizamos el MCD para dividir numerador y denominador.
     * Además, si el denominador es negativo, pasamos el signo al numerador.
     * </p>
     */
    private void simpl() {
        int iDivisorComun = mcd(Math.abs(m_iNumerador), Math.abs(m_iDenominador));
        m_iNumerador /= iDivisorComun;
        m_iDenominador /= iDivisorComun;

        if (m_iDenominador < 0) {
            m_iNumerador = -m_iNumerador;
            m_iDenominador = -m_iDenominador;
        }
    }

    /**
     * Método para calcular el máximo común divisor de dos números.
     *
     * <p>
     * Seguimos el Algoritmo de Euclides.
     * </p>
     *
     * @param iNum1 Primer número.
     * @param iNum2 Segundo número.
     * @return El MCD de los dos números.
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
     * Valida que un objeto no sea nulo.
     *
     * @param obj Objeto a comprobar.
     * @throws DatoInvalidoException() Si el objeto es nulo.
     */
    private static void validarObjeto(Object obj) throws DatoInvalidoException {
        if (obj == null) { throw new DatoInvalidoException("El objeto no puede ser nulo"); }
    }

    /**
     * Valida que un número no sea cero.
     *
     * <p>
     * Lo usamos principalmente para comprobar que el denominador no sea 0.
     * </p>
     *
     * @param iValor Valor a comprobar.
     * @throws DatoInvalidoException() Si el valor es 0.
     */
    private static void validarNumero(int iValor) throws DatoInvalidoException {
        if (iValor == 0) {
            throw new DatoInvalidoException("El número no puede ser 0");
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
