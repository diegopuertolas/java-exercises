package Retos.PruebaAutoria;

public class Pasajero implements IPasajero
{
    protected String m_strNombre;
    protected int m_iEdad;
    protected String m_strPasaporte;

    public Pasajero(String p_strNombre, int p_iEdad, String p_strPasaporte) {
        this.m_strNombre = p_strNombre;
        this.m_iEdad = p_iEdad;
        this.m_strPasaporte = p_strPasaporte;
    }

    @Override
    public String getNombre() {
        return this.m_strNombre;
    }

    @Override
    public int getEdad() { return this.m_iEdad; }

    @Override
    public String getPasaporte() {
        return this.m_strPasaporte;
    }

    @Override
    public String toString() {
        return "Pasajero --> " +
                "Nombre: " + m_strNombre +
                ",Edad: " + m_iEdad +
                ",Pasaporte: " + m_strPasaporte;
    }
}
