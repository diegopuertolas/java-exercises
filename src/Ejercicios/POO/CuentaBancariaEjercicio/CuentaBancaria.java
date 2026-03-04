package Ejercicios.POO.CuentaBancariaEjercicio;

import Ejercicios.POO.CuentaBancariaEjercicio.Constants.Enums.*;
import Ejercicios.POO.CuentaBancariaEjercicio.Types.*;
import Ejercicios.POO.CuentaBancariaEjercicio.Exceptions.MovimientoInvalidoException;
import Ejercicios.POO.CuentaBancariaEjercicio.Exceptions.SaldoInsuficienteException;

public class CuentaBancaria {

    private static final int MAX_MOVIMIENTOS = 100;

    // Propiedades
    private Titular m_eTitular;
    private IBAN m_eIBAN;
    private double m_dbSaldo;
    private Movimiento[] m_eMovimiento;
    private int m_iNumMovimiento;

    // Métodos Get y Set
    public Titular getTitular() {
        return m_eTitular;
    }

    private void setTitular(Titular value) {
        this.m_eTitular = value;
    }

    public IBAN getIBAN() {
        return m_eIBAN;
    }

    private void setIBAN(IBAN value) {
        this.m_eIBAN = value;
    }

    public double getSaldo() {
        return m_dbSaldo;
    }

    private void setSaldo(double value) {
        this.m_dbSaldo = value;
    }

    public Movimiento[] getMovimiento() {
        return m_eMovimiento;
    }

    private void setMovimiento(Movimiento[] value) {
        this.m_eMovimiento = value;
    }

    public int getNumMovimiento() {
        return m_iNumMovimiento;
    }

    private void setNumMovimiento(int value) {
        this.m_iNumMovimiento = value;
    }

    // Constructor
    public CuentaBancaria(Titular p_eTitular, IBAN p_eIBAN) {
        setTitular(p_eTitular);
        setIBAN(p_eIBAN);
        setSaldo(0.0);
        setMovimiento(new Movimiento[MAX_MOVIMIENTOS]);
        setNumMovimiento(0);
    }

    /**
     * Método para ingresar dinero en la cuenta bancaria.
     * @param strFecha String
     * @param dbCantidad double
     * @param strConcepto String
     * @param strOrdenante String
     */
    public void ingresarDinero (String strFecha, double dbCantidad, String strConcepto, String strOrdenante) throws MovimientoInvalidoException {
        // Validación
        if (dbCantidad <= 0) {
            throw new MovimientoInvalidoException("No se pueden ingresar cantidades negativas o cero");
        }

        // Calculamos el nuevo saldo.
        double dbNuevoSaldo = m_dbSaldo + dbCantidad;

        // Registramos el movimiento antes de setSaldo(dbNuevoSueldo), en caso de que se lance alguna excepción al crear el objeto movimiento.
        Movimiento movimiento = new Movimiento(strFecha, TipoMovimiento.Ingresar, dbCantidad, dbNuevoSaldo, strConcepto, strOrdenante);

        // Si no se ha lanzado ninguna excepción, hacemos el setSaldo con el nuevo saldo.
        setSaldo(dbNuevoSaldo);

        registrarMovimiento(movimiento);
    }

    /**
     * Método para retirar dinero de la cuenta bancaria
     * @param strFecha String
     * @param dbCantidad double
     * @param strConcepto String
     * @param strOrdenante String
     */
    public void retirarDinero (String strFecha, double dbCantidad, String strConcepto, String strOrdenante) throws MovimientoInvalidoException, SaldoInsuficienteException {
        // Validación
        if (dbCantidad <= 0) {
            throw new MovimientoInvalidoException("No se pueden retirar cantidades negativas");
        }
        if (m_dbSaldo < dbCantidad) {
            throw new SaldoInsuficienteException("Saldo Insuficiente");
        }

        // Calculamos el nuevo saldo.
        double dbNuevoSaldo = m_dbSaldo - dbCantidad;

        // Registramos el movimiento antes de setSaldo(dbNuevoSueldo), en caso de que se lance alguna excepción al crear el objeto movimiento.
        Movimiento movimiento = new Movimiento(strFecha, TipoMovimiento.Retirar, dbCantidad, dbNuevoSaldo, strConcepto, strOrdenante);

        // Si no se ha lanzado ninguna excepción, hacemos el setSaldo con el nuevo saldo.
        setSaldo(dbNuevoSaldo);

        registrarMovimiento(movimiento);
    }

    /**
     * Método para registrar un movimiento en la cuenta bancaria.
     * @param movimiento Clase Movimiento
     */
    private void registrarMovimiento(Movimiento movimiento) {
        if (m_iNumMovimiento < MAX_MOVIMIENTOS) {
            m_eMovimiento[m_iNumMovimiento] = movimiento;
            m_iNumMovimiento++;
        } else {
            for (int i = 0; i < MAX_MOVIMIENTOS - 1; i++) {
                m_eMovimiento[i] = m_eMovimiento[i + 1];
            }
            m_eMovimiento[MAX_MOVIMIENTOS - 1] = movimiento;
        }
    }

    /**
     * Método para imprimir los datos de la cuenta bancaria.
     */
    public void imprimirDatos() {
        System.out.println("\n--- DATOS de la CUENTA ---\n");
        System.out.println("Titular: " + m_eTitular + ".");
        System.out.println(m_eIBAN + ".");
        System.out.println("Saldo: " + m_dbSaldo + ".\n");
    }

    /**
     * Método para imprimir una lista de los movimientos realizados en la cuenta bancaria.
     */
    public void listarMovimientos() {
        System.out.println("\n--- ÚLTIMOS MOVIMIENTOS ---");
        if (m_iNumMovimiento == 0) {
            System.out.println("No hay movimientos registrados.\n");
        }
        for (int i = 0; i < m_iNumMovimiento; i++) {
            System.out.println("\n" + m_eMovimiento[i] + "\n");
        }
    }
}
