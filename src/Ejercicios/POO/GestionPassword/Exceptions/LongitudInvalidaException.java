package Ejercicios.POO.GestionPassword.Exceptions;

/**
 * Excepción para error al introducir la longitud negativa o 0;
 */
public class LongitudInvalidaException extends Exception {

    public LongitudInvalidaException(String p_strMessage) {
        super(p_strMessage);
    }
}
