package Ejercicios.POO.CuentaBancariaEjercicio.Types;

import Ejercicios.POO.CuentaBancariaEjercicio.Exceptions.TitularInvalidoException;

public class Titular {

    // Propiedades
    private String m_strName;
    private String m_strApellidos;

    // Métodos Get y Set
    public String getName() {
        return m_strName;
    }

    private void setName(String value) throws TitularInvalidoException {
        if (value.trim().isEmpty()) {
            throw new TitularInvalidoException("El nombre no puede estar vacío.");
        }
        this.m_strName = value;
    }

    public String getApellidos() {
        return m_strApellidos;
    }

    private void setApellidos(String value) throws TitularInvalidoException {
        if (value.trim().isEmpty()) {
            throw new TitularInvalidoException("El apellido no puede estar vacío.");
        }
        this.m_strApellidos = value;
    }

    // Métodos Constructor
    public Titular(String p_strName, String p_strApellidos) throws TitularInvalidoException {
        setName(p_strName);
        setApellidos(p_strApellidos);
    }

    @Override
    public String toString() {
        return m_strName + " " + m_strApellidos;
    }
}
