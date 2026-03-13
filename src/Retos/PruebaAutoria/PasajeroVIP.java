package Retos.PruebaAutoria;

public class PasajeroVIP extends Pasajero
{
    private int m_iNumeroSocio;
    private int m_iMillasAcumuladas;

    public PasajeroVIP(String p_strNombre, int p_iEdad, String p_strPasaporte, int p_iNumeroSocio, int p_iMillasAcumuladas) {
        super(p_strNombre, p_iEdad, p_strPasaporte);
        this.m_iNumeroSocio = p_iNumeroSocio;
        this.m_iMillasAcumuladas = 0;
    }

    public int getNumeroSocio() { return m_iNumeroSocio; }
    public int getMillasAcumuladas() {
        return m_iMillasAcumuladas;
    }
    public void sumarMillar(int p_iCantidad) { this.m_iMillasAcumuladas += p_iCantidad; }

    @Override
    public String toString() {
        return "PasajeroVIP --> " +
                "Numero Socio: " + m_iNumeroSocio +
                ", Millas Acumuladas: " + m_iMillasAcumuladas +
                ", Nombre: '" + m_strNombre +
                ", Edad: " + m_iEdad +
                ", Pasaporte: '" + m_strPasaporte;
    }
}
