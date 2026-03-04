package Ejercicios.Colecciones.DMSv2.exceptions;

/**
 *  Excepción personalizada que se la lanza cuando se introducen datos inválidos.
 */
public class DatosInvalidosException extends Exception {

    public DatosInvalidosException(String p_strMessage) {
        super(p_strMessage);
    }
}
