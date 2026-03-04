package Retos.GestionElectrodomesticos;

/**
 * Excepción para errores en los datos.
 */
public class DatoInvalidoException extends Exception {

    public DatoInvalidoException(String p_strMessage) {
        super(p_strMessage);
    }
}
