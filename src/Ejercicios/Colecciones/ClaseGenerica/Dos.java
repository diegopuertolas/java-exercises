package Ejercicios.Colecciones.ClaseGenerica;

public class Dos<T> {

    // Propiedades
    private T primero;
    private T segundo;

    public T getPrimero() { return primero; }
    public void setPrimero(T primero) { this.primero = primero; }

    public T getSegundo() { return segundo; }
    public void setSegundo(T segundo) { this.segundo = segundo; }

    // Constructor con parámetros
    public Dos(T p_primero, T p_segundo) {
        this.primero = p_primero;
        this.segundo = p_segundo;
    }

    @Override
    public String toString() {
        return primero + " " + segundo;
    }
}
