package Ejercicios.POO.CuentaBancariaEjercicio.Exceptions;

/**
 * Excepción para errores de datos inválidos.
 *  - El nombre del Titular no puede estar vacío.
 *  - Los apellidos del Titular no puede estar vacío.
 */
public class TitularInvalidoException extends Exception {

    public TitularInvalidoException(String p_strMessage) {
        super(p_strMessage);
    }
}
