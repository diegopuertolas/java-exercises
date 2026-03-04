package Ejercicios.POO.CuentaBancariaEjercicio.Types;

import Ejercicios.POO.CuentaBancariaEjercicio.Constants.Enums.Nacionalidad;
import Ejercicios.POO.CuentaBancariaEjercicio.Exceptions.IBANInvalidoException;

public class IBAN {

    // Constantes
    private static final int LONGITUD_IBAN = 24;
    private static final int INICIO_PAIS = 0;
    private static final int FIN_PAIS = 2;
    private static final int INICIO_CONTROL = 2;
    private static final int FIN_CONTROL = 4;
    private static final int INICIO_BANCO = 4;
    private static final int FIN_BANCO = 8;
    private static final int INICIO_SUCURSAL = 8;
    private static final int FIN_SUCURSAL = 12;
    private static final int INICIO_CONTROL2 = 12;
    private static final int FIN_CONTROL2 = 14;
    private static final int INICIO_CUENTA = 14;
    private static final int FIN_CUENTA = 24;

    // Propiedades
    private Nacionalidad m_eNacionalidad; // 2 Letras
    private String m_strCodigoControl; // 2 Dígitos
    private String m_strCodigoBanco; // 4 Dígitos
    private String m_strCodigoSucursal; // 4 Dígitos
    private String m_strCodigoControl2; // 2 Dígitos
    private String m_strCodigoCuentaCliente; // 10 Dígitos

    // Métodos Get y Set
    public Nacionalidad getNacionalidad() {
        return m_eNacionalidad;
    }

    private void setNacionalidad(Nacionalidad value) {
        this.m_eNacionalidad = value;
    }

    public String getCodigoControl() {
        return m_strCodigoControl;
    }

    private void setCodigoControl(String value) {
        this.m_strCodigoControl = value;
    }

    public String getCodigoBanco() {
        return m_strCodigoBanco;
    }

    private void setCodigoBanco(String value) {
        this.m_strCodigoBanco = value;
    }

    public String getCodigoSucursal() {
        return m_strCodigoSucursal;
    }

    private void setCodigoSucursal(String value) {
        this.m_strCodigoSucursal = value;
    }

    public String getCodigoControl2() {
        return m_strCodigoControl2;
    }

    private void setCodigoControl2(String value) {
        this.m_strCodigoControl2 = value;
    }

    public String getCodigoCuentaCliente() {
        return m_strCodigoCuentaCliente;
    }

    private void setCodigoCuentaCliente(String value) {
        this.m_strCodigoCuentaCliente = value;
    }

    // Constructor
    public IBAN(String p_strIBANCompleto) throws IBANInvalidoException {

        if (p_strIBANCompleto.length() != LONGITUD_IBAN)  {
            throw new IBANInvalidoException("El IBAN debe tener " + LONGITUD_IBAN + " caracteres");
        }

        // Validación de la nacionalidad.
        String strCodigoPais = p_strIBANCompleto.substring(INICIO_PAIS, FIN_PAIS);

        if (!strCodigoPais.equals(strCodigoPais.toUpperCase())) {
            throw new IBANInvalidoException("El código del país debe estar en letras mayúsculas.");
        }

        // Creamos una variable local y la asignamos al parámetro, de esta manera evitamos modificar el parámetro de entrada, haciéndolo de solo lectura.
        String strIBANCompletoUpperCase = p_strIBANCompleto.toUpperCase();

        boolean bPaisEncontrado = false;
        for (Nacionalidad ePais : Nacionalidad.values()) {
            // .name() para convertir el Enum en String, y así poder compararlo usando el .equals()
            if (ePais.name().equals(strCodigoPais)) {
                setNacionalidad(ePais);
                bPaisEncontrado = true;
            }
        }

        if (!bPaisEncontrado) {
            throw new IBANInvalidoException("El código del país " + strCodigoPais + " no es correcto o no está incluido");
        }

        // Validación del Código Númerico
        for (int i = INICIO_CONTROL; i < p_strIBANCompleto.length(); i++) {
            char c = strIBANCompletoUpperCase.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IBANInvalidoException("A partir del tercer carácter, todo deben ser números");
            }
        }

        setCodigoControl(strIBANCompletoUpperCase.substring(INICIO_CONTROL, FIN_CONTROL));
        setCodigoBanco(strIBANCompletoUpperCase.substring(INICIO_BANCO, FIN_BANCO));
        setCodigoSucursal(strIBANCompletoUpperCase.substring(INICIO_SUCURSAL, FIN_SUCURSAL));
        setCodigoControl2(strIBANCompletoUpperCase.substring(INICIO_CONTROL2, FIN_CONTROL2));
        setCodigoCuentaCliente(strIBANCompletoUpperCase.substring(INICIO_CUENTA, FIN_CUENTA));
    }

    @Override
    public String toString() {
        return String.format("- IBAN: %s%s %s %s %s %s", m_eNacionalidad, m_strCodigoControl, m_strCodigoBanco, m_strCodigoSucursal, m_strCodigoControl2, m_strCodigoCuentaCliente );
    }
}
