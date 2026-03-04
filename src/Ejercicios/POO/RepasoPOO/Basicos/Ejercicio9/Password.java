package Ejercicios.POO.RepasoPOO.Basicos.Ejercicio9;

public class Password {

    private static final int LONGITUD_MIN = 4;
    private static final int LONGITUD_MAX = 12;

    // Contraseña por defecto para que no de error por las validaciones.
    private static final String DEFAULT_PASSWORD = "1234Aa.";

    // Propiedades
    private String m_strPassword;

    // Métodos Get
    public String getPassword() { return m_strPassword; }

    // Métodos Set
    public void setPassword(String value) {
        validarPassword(value);

        this.m_strPassword = value;
    }

    // Constructor con parámetros
    public Password(String p_strPassword) {
        setPassword(p_strPassword);
    }

    // Constructor por defecto
    public Password() {
        this(DEFAULT_PASSWORD);
    }

    // Constructor copia
    public Password(Password otro) {
        validarObjeto(otro);
        setPassword(otro.getPassword());
    }

    /**
     * Método para validar si una contraseña es correcta, si no lo hemos lanzamos una excepción.
     * @param strValue String
     */
    private static void validarPassword(String strValue) {
        if (strValue == null) throw new IllegalArgumentException("La contraseña no puede ser nula");
        if (strValue.length() < LONGITUD_MIN || strValue.length() > LONGITUD_MAX) throw new IllegalArgumentException("La contraseña no cumple con la longitud correcta.");

        // Comprobamos si la contraseña cuenta con los tipos de carácteres necesarios
        boolean bMayuscula = false;
        boolean bMinuscula = false;
        boolean bNumero = false;
        boolean bCaracterEspecial = false;

        for (int i = 0; i < strValue.length(); i++) {
            char cLetraActual = strValue.charAt(i);

            if (Character.isUpperCase(cLetraActual)) bMayuscula = true;
            else if (Character.isLowerCase(cLetraActual)) bMinuscula = true;
            else if (Character.isDigit(cLetraActual)) bNumero = true;
            else bCaracterEspecial = true;
        }

        if (!bMayuscula) throw new IllegalArgumentException("Letra mayúscula obligatoria");
        if (!bMinuscula) throw new IllegalArgumentException("Letra minúscula obligatoria");
        if (!bNumero) throw new IllegalArgumentException("Número obligatoria");
        if (!bCaracterEspecial) throw new IllegalArgumentException("Carácter especial obligatoria");

    }

    /**
     * Método para validar si un objeto es nulo, si lo es lanzamos una excepción.
     * @param obj Clase Object
     */
    private static void validarObjeto(Object obj) {
        if (obj == null) throw new IllegalArgumentException("El objeto no puede ser nulo");
    }
    @Override
    public String toString() {
        return m_strPassword;
    }
}
