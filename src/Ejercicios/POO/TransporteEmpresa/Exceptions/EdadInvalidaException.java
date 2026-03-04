package Ejercicios.POO.TransporteEmpresa.Exceptions;

/**
 * Excepción para errores en la edad de la persona
 */
public class EdadInvalidaException extends Exception {

    public EdadInvalidaException(String p_strMessage) {
        super(p_strMessage);
    }
}
