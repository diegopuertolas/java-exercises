package Ejercicios.Colecciones.EjercicioNodos;

public class Lista {

    // Propiedades
    private Nodo m_eNodo;
    private int m_iLongitud;

    // Métodos Get y Set
    public Nodo getNodo() { return m_eNodo; }
    private void setNodo(Nodo value) { this.m_eNodo = value; }

    public int getLongitud() { return m_iLongitud; }
    public void setLongitud(int longitud) { this.m_iLongitud = longitud; }

    // Constructor por defecto.
    public Lista() {
        m_eNodo = null;
        m_iLongitud = 0;
    }

    public void insertar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);

        if (m_eNodo == null) {
            m_eNodo = nuevoNodo;
        } else {
            Nodo nodoActual = m_eNodo;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
        m_iLongitud++;
    }

    public void listar() {
        if (m_eNodo == null) {
            throw new IllegalArgumentException("La lista está vacía");
        } else {
            Nodo nodoActual = m_eNodo;
            while (nodoActual != null) {
                System.out.print(nodoActual.getValor() + " ");
                nodoActual = nodoActual.getSiguiente(); // Avanzar al siguiente
            }
            System.out.println("\nFin de la lista");
        }
    }
}
