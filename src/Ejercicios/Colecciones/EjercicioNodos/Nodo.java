package Ejercicios.Colecciones.EjercicioNodos;

public class Nodo {

    // Propiedades
    private int m_iValor;
    private Nodo m_eSiguiente;

    // Métodos Get y Set
    public int getValor() { return m_iValor; }
    private void setValor(int value) { this.m_iValor = value; }

    public Nodo getSiguiente() { return m_eSiguiente; }
    void setSiguiente(Nodo value) { this.m_eSiguiente = value; }

    public Nodo(int p_iValor) {
        setValor(p_iValor);
        setSiguiente(null);
    }
}

