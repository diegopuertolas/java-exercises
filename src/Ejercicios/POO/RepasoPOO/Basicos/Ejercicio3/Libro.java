package Ejercicios.POO.RepasoPOO.Basicos.Ejercicio3;

public class Libro {

    // Propiedades
    private String m_strTitulo;
    private boolean m_bPrestado;

    // Métodos Get
    public String getTitulo() { return m_strTitulo; }
    public boolean isPrestado() { return  m_bPrestado; }

    // Métodos Set
    private void setTitulo(String value) {
        validarTexto(value);
        this.m_strTitulo = value;
    }

    private void setPrestado(boolean value) {
        this.m_bPrestado = value;
    }

    // Constructor con parámetros
    public Libro(String p_strTitulo) {
        setTitulo(p_strTitulo);
        setPrestado(false);
    }

    // Constructor por defecto
    public Libro() {
        this("TITULO INDEFINIDO");
    }

    // Constructor copia
    public Libro(Libro otro) {
        validarObjeto(otro);
        setTitulo(otro.getTitulo());
        setPrestado(otro.isPrestado());
    }

    /**
     * Método para prestar un libro
     */
    public void prestarLibro() {
        if (m_bPrestado) {
            System.out.println("El libro ya está prestado.");
        } else {
            m_bPrestado = true;
            System.out.println("El libro '" + m_strTitulo + "' ha sido prestado.");
        }
    }

    /**
     * Método para devolver libro
     */
    public void devolverLibro() {
        if (!m_bPrestado) {
            System.out.println("El libro no está prestado.");
        } else {
            m_bPrestado = false;
            System.out.println("El libro '" + m_strTitulo + "' ha sido devuelto.");
        }
    }

    /**
     * Método para validar si un texto es nulo o está vacía, si lo es lanzamos excepción.
     * @param strValor String
     */
    private static void validarTexto(String strValor) {
        if (strValor == null || strValor.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }
    }

    /**
     * Método para validar si un objeto es nulo, si lo es lanzamos excepción.
     * @param obj Clase Object
     */
    private static void validarObjeto(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("El objeto no puede ser nulo");
        }
    }

    @Override
    public String toString() {
        return "Libro --> " +
                "Título = '" + m_strTitulo +
                "', Prestado = " + m_bPrestado + ".";
    }
}
