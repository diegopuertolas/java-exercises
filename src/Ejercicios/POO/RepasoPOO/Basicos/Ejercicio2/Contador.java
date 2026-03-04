package Ejercicios.POO.RepasoPOO.Basicos.Ejercicio2;

public class Contador {

    // Propiedades
    private int m_iCantidad;

    // Get
    public int getCantidad() { return m_iCantidad; }

    // Set
    private void setCantidad(int value) {
        this.m_iCantidad = value;
    }

    // Constructor con parámetro
    public Contador(int p_iCantidad) {
        setCantidad(p_iCantidad);
    }

    // Constructor por defecto
    public Contador() {
        this(0);
    }

    // Constructor copia
    public Contador(Contador otro) {
        validarObjeto(otro);
        setCantidad(otro.getCantidad());
    }

    /**
     * Método para incrementar el contador en uno.
     */
    public void incrementarContador() {
        m_iCantidad++;
        System.out.println("Cantidad: " + m_iCantidad);
    }

    /**
     * Método para decrementar el contador en uno.
     */
    public void decrementarContador() {
        m_iCantidad--;
        System.out.println("Cantidad: " + m_iCantidad);
    }

    /**
     * Método para validar si un objeto es nulo.
     * @param obj Clase Object
     */
    private static void validarObjeto(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("El objeto no puede ser nulo");
        }
    }

    @Override
    public String toString() {
        return "Cantidad: " + m_iCantidad;
    }
}
