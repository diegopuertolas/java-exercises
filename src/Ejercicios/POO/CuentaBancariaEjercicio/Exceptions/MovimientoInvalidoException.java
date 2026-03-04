package Ejercicios.POO.CuentaBancariaEjercicio.Exceptions;

/**
 * Excepción para errores en el movimiento.
 *  - La fecha del movimiento no puede estar vacía.
 *  - La cantidad del movimiento debe ser mayor que 0.
 *  - El concepto del movimiento no puede estar vacío.
 *  - El ordenante del movimiento no puede estar vacío.
 */
public class MovimientoInvalidoException extends Exception {

    public MovimientoInvalidoException(String p_strMessage) {
        super(p_strMessage);
    }
}
