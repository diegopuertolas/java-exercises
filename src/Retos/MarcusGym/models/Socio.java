package Retos.MarcusGym.models;

import Ejercicios.Colecciones.DMSv2.exceptions.DatosInvalidosException;
import Retos.MarcusGym.enums.TipoMembresia;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Socio extends Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // Atributos
    private TipoMembresia m_eTipoMembresia;
    private double m_dbPesoActual;

    // Métodos Get
    public TipoMembresia getTipoMembresia() { return m_eTipoMembresia; }
    public double getPesoActual() { return m_dbPesoActual; }

    // Métodos Set
    private void setTipoMembresia(TipoMembresia value) throws DatosInvalidosException {
        if (value == null) throw new DatosInvalidosException("El tipo de membresia no puede ser nula.");
        this.m_eTipoMembresia = value;
    }

    private void setPesoActual(double value) throws DatosInvalidosException {
        if (value <= 0) throw new DatosInvalidosException("El peso no puede ser negativa o igual a 0");
        this.m_dbPesoActual = value;
    }

    // Constructor con parámetros
    public Socio(String p_strDNI, String p_strNombre, String p_strApellidos, int p_iEdad,
                 TipoMembresia p_eTipoMembresia, double p_dbPesoActual) throws DatosInvalidosException
    {
        super(p_strDNI, p_strNombre, p_strApellidos, p_iEdad);
        setTipoMembresia(p_eTipoMembresia);
        setPesoActual(p_dbPesoActual);

    }

    @Override
    public String mostrarRutina() {
        return "VAMOSSSSS CHAVAL ECHALE PITERA!!!!";
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo Membresia: " + getTipoMembresia() + " | Peso Actual: " + getPesoActual();
    }
}
