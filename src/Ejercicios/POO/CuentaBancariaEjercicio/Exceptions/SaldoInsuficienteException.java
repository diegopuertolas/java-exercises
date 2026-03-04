package Ejercicios.POO.CuentaBancariaEjercicio.Exceptions;

/**
 * Excepción para error de saldo insuficiente.
 *  - El saldo no puede ser menos a la cantidad a retirar.
 */
public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String p_strMessage) {
        super(p_strMessage);
    }
}
