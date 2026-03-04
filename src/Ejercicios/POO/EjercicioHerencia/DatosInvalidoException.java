package Ejercicios.POO.EjercicioHerencia;

/**
 * Excepción para errores de validación
 */
public class DatosInvalidoException extends Exception {

    public DatosInvalidoException(String p_strMessage) {
        super(p_strMessage);
    }
}
