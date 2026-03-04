package Ejercicios.Colecciones.DMSv2.exceptions;

/**
 * Excepción personalizada que se lanza cuando se realiza una búsqueda de un dinosaurio
 * en el registro del parque y este no existe.
 */
public class DinosaurioNoEncontradoException extends Exception {

    public DinosaurioNoEncontradoException(String p_strMessage) {
        super(p_strMessage);
    }
}
