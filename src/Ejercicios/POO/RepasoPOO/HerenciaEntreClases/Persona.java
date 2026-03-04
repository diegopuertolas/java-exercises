package Ejercicios.POO.RepasoPOO.HerenciaEntreClases;

public class Persona {

    private static final int LONGITUD_MIN = 2;
    private static final String NOMBRE_DEFAULT = "undefined";
    private static final String APELLIDO_DEFAULT = "undefined";

    // Propiedades
    private String m_strNombre;
    private String m_strApellidos;

    // Métodos Get
    public String getNombre() { return m_strNombre; }
    public String getApellidos() { return m_strApellidos; }

    // Métodos Set
    private void setNombre(String value) {
        validarDatos(value, "Nombre", LONGITUD_MIN);
        this.m_strNombre = value;
    }

    private void setApellidos(String value) {
        validarDatos(value, "Apellidos", LONGITUD_MIN);
        this.m_strApellidos = value;
    }

    // Constructor con parámetros
    public Persona(String p_strNombre, String p_strApellidos) {
        setNombre(p_strNombre);
        setApellidos(p_strApellidos);
    }

    // Constructor por defecto
    public Persona() {
        this(NOMBRE_DEFAULT, APELLIDO_DEFAULT);
    }

    // Constructor copia
    public Persona(Persona otro) {
        validarObjeto(otro);

        setNombre(otro.getNombre());
        setApellidos(otro.getApellidos());
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
        return m_strNombre + " " + m_strApellidos;
    }

}
