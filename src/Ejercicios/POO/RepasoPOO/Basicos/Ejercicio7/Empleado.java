package Ejercicios.POO.RepasoPOO.Basicos.Ejercicio7;

public class Empleado {

    // Propiedad única de la clase Empleado
    private static final String CODIGO_EMPRESA = "Ajs12UptV721";
    private static final int LONGITUD_DATOS = 2;

    // Propiedades
    private String m_strNombre;
    private String m_strApellido;

    // Métodos Get
    public String getNombre() { return m_strNombre; }
    public String getApellido() { return m_strApellido; }

    // Métodos Set
    private void setNombre(String value) {
        validarDatos(value, "Nombre", LONGITUD_DATOS);
        this.m_strNombre = value;
    }
    private void setApellido(String value) {
        validarDatos(value, "Apellido", LONGITUD_DATOS);
        this.m_strApellido = value;
    }

    // Constructor con parámetros
    public Empleado(String p_strNombre, String p_strApellido) {
        setNombre(p_strNombre);
        setApellido(p_strApellido);
    }

    // Constructor por defecto
    public Empleado() {
        this("Indefinido", "Indefinido");
    }

    // Constructor copia
    public Empleado(Empleado otro) {
        validarObjeto(otro);

        setNombre(otro.getNombre());
        setApellido(otro.getApellido());
    }

    /**
     * Método para validar si los datos cumplen con la longitud mínima de carácteres, si no lo cumple lanzamos excepción.
     * @param strValor String
     * @param strCampo String
     * @param iLongitudMinima int
     */
    private static void validarDatos(String strValor, String strCampo, int iLongitudMinima) {
        if (strValor == null) throw new IllegalArgumentException("El campo " + strCampo + " no puede ser nulo.");
        if (strValor.trim().length() < iLongitudMinima) throw new IllegalArgumentException("El campo " + strCampo + " no cumple con la longitud mínima.");
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
        return "CODIGO EMPRESA: " + CODIGO_EMPRESA + " | " + m_strNombre + " " + m_strApellido;
    }
}
