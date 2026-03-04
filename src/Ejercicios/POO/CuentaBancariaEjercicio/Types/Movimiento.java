package Ejercicios.POO.CuentaBancariaEjercicio.Types;

import Ejercicios.POO.CuentaBancariaEjercicio.Constants.Enums.TipoMovimiento;
import Ejercicios.POO.CuentaBancariaEjercicio.Exceptions.MovimientoInvalidoException;

public class Movimiento {

    // Static ya que pertenece a la clase, no al objeto.
    private static int iContadorIDs = 1;

    // Propiedades
    private int m_iID;
    private String m_strFecha;
    private TipoMovimiento m_eTipoMovimiento;
    private double m_dbCantidad;
    private double m_dbSaldoRestante;
    private String m_strConcepto;
    private String m_strOrdenante;

    // Métodos Get y Set
    public int getID() {
        return m_iID;
    }

    private void setID(int value) {
        this.m_iID = value;
    }

    public String getFecha() {
        return m_strFecha;
    }

    private void setFecha(String value) throws MovimientoInvalidoException {
        if (value.trim().isEmpty()) {
            throw new MovimientoInvalidoException("La fecha del movimiento no puede estar vacía.");
        }
        this.m_strFecha = value;
    }

    public TipoMovimiento getTipoMovimiento() {
        return m_eTipoMovimiento;
    }

    private void setTipoMovimiento(TipoMovimiento value) {
        this.m_eTipoMovimiento = value;
    }

    public double getCantidad() {
        return m_dbCantidad;
    }

    private void setCantidad(double value) throws MovimientoInvalidoException {
        if (value <= 0) {
            throw new MovimientoInvalidoException("La cantidad del movimiento debe ser mayor a 0");
        }
        this.m_dbCantidad = value;
    }

    public double getSaldoRestante() {
        return m_dbSaldoRestante;
    }

    private void setSaldoRestante(double value) {
        this.m_dbSaldoRestante = value;
    }

    public String getConcepto() {
        return m_strConcepto;
    }

    private void setConcepto(String value) throws MovimientoInvalidoException {
        if (value.trim().isEmpty()) {
            throw new MovimientoInvalidoException("El movimiento debe tener un concepto.");
        }
        this.m_strConcepto = value;
    }

    public String getOrdenante() {
        return m_strOrdenante;
    }

    private void setOrdenante(String value) throws MovimientoInvalidoException {
        if (value.trim().isEmpty()) {
            throw new MovimientoInvalidoException("El movimiento debe tener un ordenante.");
        }
        this.m_strOrdenante = value;
    }

    // Constructor
    public Movimiento(String p_strFecha, TipoMovimiento p_eTipoMovimiento, double p_dbCantidad,
                      double p_dbSaldoRestante, String p_strConcepto, String p_strOrdenante)
            throws MovimientoInvalidoException {
        setID(iContadorIDs++);
        setFecha(p_strFecha);
        setTipoMovimiento(p_eTipoMovimiento);
        setCantidad(p_dbCantidad);
        setSaldoRestante(p_dbSaldoRestante);
        setConcepto(p_strConcepto);
        setOrdenante(p_strOrdenante);
    }

    @Override
    public String toString() {
        return "Movimiento: " +
                "ID = " + m_iID +
                ", Fecha = " + m_strFecha +
                ", Movimiento = " + m_eTipoMovimiento +
                ", Cantidad = " + m_dbCantidad +
                ", SaldoRestante = " + m_dbSaldoRestante +
                ", Concepto = " + m_strConcepto +
                ", Ordenante = " + m_strOrdenante +
                ".";
    }
}
