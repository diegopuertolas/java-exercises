package Ejercicios.POO.TransporteEmpresa.Exceptions;

/**
 * Excepción para errores en los datos de la persona.
 * - Longitud del nombre.
 * - Longitud del apellido.
 */
public class DatosInvalidosException extends Exception {

    public DatosInvalidosException(String p_strMessage) {
        super(p_strMessage);
    }
}
