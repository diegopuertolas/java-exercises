package Ejercicios.Colecciones.CajaMisteriosa;

public class Producto {

    // Propiedades
    private String m_strNombre;
    private double m_dbPrecio;

    // Métodos Get y Set
    public String getNombre() { return m_strNombre; }
    public double getPrecio() { return m_dbPrecio; }

    private void setNombre(String value) {
        if (value == null || value.trim().isEmpty()) throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        this.m_strNombre = value;
    }

    private void setPrecio(double value) {
        if (value < 0) throw new IllegalArgumentException("El precio no puede ser negativo.");
        this.m_dbPrecio = value;
    }

    // Constructor
    public Producto(String p_strNombre, double p_dbPrecio) {
        setNombre(p_strNombre);
        setPrecio(p_dbPrecio);
    }

    @Override
    public String toString() {
        return "Nombre: " + this.m_strNombre + " | Precio: " + this.m_dbPrecio;
    }
}
