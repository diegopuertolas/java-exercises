package Retos.PruebaAutoria;

import java.util.LinkedList;

public class Vuelo extends LinkedList<PasajeroVIP>
{
    private String m_strCodigoVuelo;
    private int m_iCapacidadMaxima;

    public Vuelo(String p_strCodigoVuelo, int p_iCapacidadMaxima) {
        this.m_strCodigoVuelo = p_strCodigoVuelo;
        this.m_iCapacidadMaxima = p_iCapacidadMaxima;
    }

    public String getCodigoVuelo() { return this.m_strCodigoVuelo; }
    public int getCapacidadMaxima() {
        return this.m_iCapacidadMaxima;
    }
    public boolean estaLleno() { return this.size() == this.m_iCapacidadMaxima; }

    @Override
    public String toString() {
        return "Vuelo --> " +
                "CodigoVuelo: " + m_strCodigoVuelo +
                ", Capacidad Maxima: " + m_iCapacidadMaxima;
    }
}
