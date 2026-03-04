package Ejercicios.POO.ExcepcionesEjercicios.Ejercicio7;

/**
 * Excepción para trabajar con los errores de validación de la clase Gato.
 */
public class DatoInvalidoException extends Exception {

    public DatoInvalidoException(String p_strMessage) {
        super(p_strMessage);
    }
}
