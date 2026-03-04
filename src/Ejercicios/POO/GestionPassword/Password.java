package Ejercicios.POO.GestionPassword;

import Ejercicios.POO.GestionPassword.Exceptions.LongitudInvalidaException;

public class Password {

    private static final int LONGITUD_DEFAULT = 8;
    private static final String BANCO_CARACTERES = "ABCDEFGHIJKLMNÑOPQRSTUVWYZabcdefghijklmnñopqrstuvwyz0123456789";

    // Propiedades
    private int m_iLongitud;
    private String m_strPassword;

    // Métodos Get
    public int getLongitud() { return m_iLongitud; }
    public String getPassword() { return m_strPassword; }

    // Métodos Set
    private void setLongitud(int value) throws LongitudInvalidaException {
        if (value <= 0) throw new LongitudInvalidaException("La longitud no puede ser ni negativa ni igual a 0.");

        this.m_iLongitud = value;
        this.m_strPassword = generarPassword(value);
    }

    public Password(int p_iLongitud) throws LongitudInvalidaException {
        setLongitud(p_iLongitud);
    }

    public Password() throws LongitudInvalidaException {
        this(LONGITUD_DEFAULT);
    }

    /**
     * Método para generar una contraseña aleatoria siguiendo unos carácteres preestablecidos.
     * @param iLongitud int
     * @return String
     */
    private String generarPassword(int iLongitud) {
        String strPassword = "";
        for (int i = 0; i < iLongitud; i++) {
            int iEleccion = (int) (Math.random() * BANCO_CARACTERES.length());
            strPassword += BANCO_CARACTERES.charAt(iEleccion);
        }

        return strPassword;

        /* STRING BUILDER: Mucho mas eficiente en memoria.
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < iLongitud; i++) {
                int iEleccion = (int) (Math.random() * BANCO_CARACTERES.length());
                sb.append(BANCO_CARACTERES.charAt(iEleccion));
            }
            return sb.toString();
        */
    }

    /**
     * Método para comprobar si una contraseña es fuerte.
     * @return true / false
     */
    public boolean esFuerte() {
        int iNumMayuscula = 0;
        int iNumMinuscula = 0;
        int iNumNumeros = 0;

        for (int i = 0; i < this.m_strPassword.length(); i++) {
            char cLetraActual = this.m_strPassword.charAt(i);

            if (Character.isUpperCase(cLetraActual)) iNumMayuscula++;
            else if (Character.isLowerCase(cLetraActual)) iNumMinuscula++;
            else if (Character.isDigit(cLetraActual)) iNumNumeros++;
        }

        return iNumMayuscula > 2 && iNumMinuscula > 1 && iNumNumeros > 5;
    }

    @Override
    public String toString() {
        return m_strPassword;
    }
}
