package Ejercicios.POO.RepasoPOO.RelacionComposicionEntreClases;

import Ejercicios.POO.RepasoPOO.Basicos.Ejercicio6.Fecha;

public class Persona {

    private static final int LONGITUD_MIN = 2;
    private static final String NOMBRE_DEFAULT = "undefined";
    private static final String APELLIDO_DEFAULT = "undefined";

    // Propiedades
    private String m_strNombre;
    private String m_strApellidos;
    private Fecha m_eFechaNacimiento;

    // Métodos Get
    public String getNombre() { return m_strNombre; }
    public String getApellidos() { return m_strApellidos; }
    public Fecha getFechaNacimiento() {

        // Devolvemos una copia de la fecha original, así nadie puede modificar la fecha.
        return new Fecha(m_eFechaNacimiento);
    }

    // Métodos Set
    private void setNombre(String value) {
        validarDatos(value, "Nombre", LONGITUD_MIN);
        this.m_strNombre = value;
    }

    private void setApellidos(String value) {
        validarDatos(value, "Apellidos", LONGITUD_MIN);
        this.m_strApellidos = value;
    }

    private void setFechaNacimiento(Fecha value) {
        validarObjeto(value);

        // Creamos una nueva fecha basada en los datos de la fecha que pasamos como parámetro.
        this.m_eFechaNacimiento = new Fecha(value);
    }

    // Constructor con parámetros
    public Persona(String p_strNombre, String p_strApellidos, Fecha p_eFechaNacimiento) {
        setNombre(p_strNombre);
        setApellidos(p_strApellidos);
        setFechaNacimiento(p_eFechaNacimiento);
    }

    // Constructor por defecto
    public Persona() {
        this(NOMBRE_DEFAULT, APELLIDO_DEFAULT, new Fecha(1, 1, 2000));
    }

    // Constructor copia
    public Persona(Persona otro) {
        validarObjeto(otro);

        setNombre(otro.getNombre());
        setApellidos(otro.getApellidos());
        setFechaNacimiento(otro.getFechaNacimiento());
    }

    /**
     * Método para validar los datos de la persona, si no son correctos lanzamos una excepción.
     * @param strValor String
     * @param strCampo String
     * @param iLongMin String
     */
    private static void validarDatos(String strValor, String strCampo, int iLongMin) {
        if (strValor == null) throw new IllegalArgumentException("Los datos no pueden ser nulos");
        if (strValor.trim().length() < iLongMin) throw new IllegalArgumentException("Los datos del campo " + strCampo + " no cumplen con la longitud mínima.");
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
        return m_strNombre + " " + m_strApellidos + " | " + m_eFechaNacimiento;
    }
}
