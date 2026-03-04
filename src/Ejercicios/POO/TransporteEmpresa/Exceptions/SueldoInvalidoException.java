package Ejercicios.POO.TransporteEmpresa.Exceptions;

/**
 * Excepción para errores en el saldo del empleado.
 */
public class SueldoInvalidoException extends Exception {

    public SueldoInvalidoException(String p_strMessage) {
        super(p_strMessage);
    }
}
