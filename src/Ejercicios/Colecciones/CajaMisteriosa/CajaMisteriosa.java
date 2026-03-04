package Ejercicios.Colecciones.CajaMisteriosa;

public class CajaMisteriosa<T /* extends Number */> {

    // Propiedades
    private T m_contenido;

    // Métodos Get y Set
    public T getContenido() { return m_contenido; }
    public void setContenido(T value) { this.m_contenido = value; }

    // Constructor
    public CajaMisteriosa(T p_contenido) {
        setContenido(p_contenido);
    }

    /**
     * Muestra el tipo real que guarda la caja.
     * @throws IllegalStateException Si la caja misteriosa está vacía.
     * No uso IllegalArgumentException ya que no estoy pasando ningún parámetro a este método.
     */
    public void mostrarTipo() {
        if (this.m_contenido == null) {
            throw new IllegalStateException("Caja misteriosa vacía.");
        }
        String strTipo = this.m_contenido.getClass().getSimpleName();
        System.out.println("El tipo real que guarda la caja es: " + strTipo);
    }

    /**
     * Método genérico estático que revela el tipo y contenido de CUALQUIER objeto.
     * Como voy a usar un tipo genérico T, debo declararlo (<T>), así el parámetro entiende
     * porque tiene ese tipo, ya que lo he declarado previamente.
     * Así cumple con el enunciado ya que nos pide un método genérico independiente.
     * @param p_objeto El tipo genérico del objeto ingresado.
     */
    public static <T> void revelarObjeto(T p_objeto) {
        if (p_objeto == null) {
            System.out.println("El objeto no puede estar vacío.");
            return;
        }

        String strTipo = p_objeto.getClass().getSimpleName();
        System.out.println("El tipo real que guarda la caja es: " + strTipo);
    }

    /**
     * Muestra el contenido de la caja con un mensaje misterioso.
     * @throws IllegalStateException Si la caja no tiene contenido.
     * No uso IllegalArgumentException ya que no estoy pasando ningún parámetro a este método.
     */
    public void abrirCaja() {
        if (this.m_contenido == null) {
            throw new IllegalStateException("No se puede abrir la caja ya que no tiene contenido.");
        }
        System.out.println("El misterio de ... " + this.m_contenido);
    }

}
