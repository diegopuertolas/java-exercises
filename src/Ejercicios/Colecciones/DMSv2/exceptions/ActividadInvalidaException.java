package Ejercicios.Colecciones.DMSv2.exceptions;

/**
 * Excepción personalizada que se lanza cuando se intenta asignar a un dinosaurio
 * a una actividad que no es compatible con su naturaleza o dieta.
 */
public class ActividadInvalidaException extends Exception {

    public ActividadInvalidaException(String p_strMessage) {
        super(p_strMessage);
    }
}
