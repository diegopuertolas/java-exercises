package Ejercicios.POO.RepasoPOO.Basicos.Ejercicio1;

public class Cuenta {

    // Propiedades
    private String m_strNumeroCuenta;
    private String m_strTitular;
    private double m_dbSaldo;

    // Métodos Get
    public String getNumeroCuenta() { return m_strNumeroCuenta; }
    public String getTitular() { return m_strTitular; }
    public double getSaldo() { return m_dbSaldo; }

    // Métodos Set
    private void setNumeroCuenta(String value) {
        validarTexto(value, "Numero de Cuenta");
        this.m_strNumeroCuenta = value;
    }

    private void setTitular(String value) {
        validarTexto(value, "Titular");
        this.m_strTitular = value; }

    private void setSaldo(double value) {
        this.m_dbSaldo = value;
    }

    // Constructor con parámetros
    public Cuenta(String p_strNumeroCuenta, String p_strTitular) {
        setNumeroCuenta(p_strNumeroCuenta);
        setTitular(p_strTitular);
        setSaldo(0.0);
    }

    // Constructor por defecto
    public Cuenta() {
        this("NUMERO DE CUENTA INDEFINIDO", "TITULAR INDEFINIDO");
    }

    // Constructor copia.
    public Cuenta(Cuenta otro) {
        validarObjeto(otro, "No se puede copiar una cuenta nula.");
        setNumeroCuenta(otro.getNumeroCuenta());
        setTitular(otro.getTitular());
        setSaldo(otro.getSaldo());
    }

    /**
     * Método para ingresar dinero en la cuenta.
     * @param dbCantidad double
     */
    public void ingresarDinero(double dbCantidad) {
        validarCantidadPositiva(dbCantidad);
        m_dbSaldo += dbCantidad;
        System.out.println("Usted ha ingresado " + dbCantidad + "€.");
        System.out.println("TOTAL: " + m_dbSaldo + "€.");
    }

    /**
     * Método para sacar dinero de la cuenta.
     * @param dbCantidad double
     */
    public void sacarDinero(double dbCantidad) {

        validarCantidadPositiva(dbCantidad);
        validarFondosSuficientes(dbCantidad);

        m_dbSaldo -= dbCantidad;
        System.out.println("Usted ha retirado " + dbCantidad + "€.");
        System.out.println("TOTAL: " + m_dbSaldo + "€.");
    }

    /**
     * Método para transferir dinero de una cuenta a otra.
     * @param dbCantidad double
     * @param cuentaDestino Clase Cuenta
     */
    public void transferirDinero(Cuenta cuentaDestino, double dbCantidad) {
        validarObjeto(cuentaDestino, "La cuenta de destino es nula.");
        sacarDinero(dbCantidad);
        cuentaDestino.ingresarDinero(dbCantidad);
        System.out.println("Transferencia de: " + dbCantidad + "€ a la cuenta " + cuentaDestino.getNumeroCuenta());
    }

    /**
     * Método para validar que el texto no sea ni nulo ni este vacío, en caso de que lo este lanzamos una excepción.
     * @param strValor String
     * @param strNombreCampo String
     */
    private static void validarTexto(String strValor, String strNombreCampo) {
        if (strValor == null || strValor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + strNombreCampo + " no puede estar vacío.");
        }
    }

    /**
     * Método para validar que un objeto no sea nulo, en caso de que lo sea lanzamos una excepción.
     * @param obj Clase Object
     * @param strMensaje String
     */
    private static void validarObjeto(Object obj, String strMensaje) {
        if (obj == null) {
            throw new IllegalArgumentException(strMensaje);
        }
    }

    /**
     * Método para validar la operación, si la cantidad es menor o igual a 0, lanzamos una excepción.
     * @param dbCantidad double
     */
    private void validarCantidadPositiva(double dbCantidad) {
        if (dbCantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
    }

    /**
     * Método para validar si quedan fondos suficientes en la cuenta.
     * @param dbCantidad double
     */
    private void validarFondosSuficientes(double dbCantidad) {
        if (dbCantidad > m_dbSaldo) {
            throw new IllegalArgumentException("Saldo insuficiente, quieres sacar " + dbCantidad + "€ y tienes " + m_dbSaldo + "€.");
        }
    }

    @Override
    public String toString() {
        return "Cuenta --> " +
                "Numero de Cuenta: '" + m_strNumeroCuenta + '\'' +
                ", Titular = '" + m_strTitular + '\'' +
                ", Saldo = " + m_dbSaldo;
    }
}
