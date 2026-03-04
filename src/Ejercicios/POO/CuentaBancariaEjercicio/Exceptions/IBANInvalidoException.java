package Ejercicios.POO.CuentaBancariaEjercicio.Exceptions;

/**
 * Excepción para errores de validación del IBAN:
 *  - Longitud del IBAN.
 *  - Código de país en letras mayúsculas.
 *  - Código de país incorrecto.
 *  - Código númerico incorrecto.
 */
public class IBANInvalidoException extends Exception {

    public IBANInvalidoException(String p_strMessage) {
        super(p_strMessage);
    }
}
