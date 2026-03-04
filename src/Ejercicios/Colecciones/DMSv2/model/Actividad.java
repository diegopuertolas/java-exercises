package Ejercicios.Colecciones.DMSv2.model;

import Ejercicios.Colecciones.DMSv2.enums.TipoDieta;
import Ejercicios.Colecciones.DMSv2.exceptions.DatosInvalidosException;

public class Actividad {

    // Propiedades
    private String m_strNombre;
    private TipoDieta m_eTipoDieta;

    // Métodos Get
    public String getNombreActividad() { return m_strNombre; }
    public TipoDieta getTipoDieta() { return m_eTipoDieta; }

    // Métodos Set
    private void setNombreActividad(String value) throws DatosInvalidosException {
        if (value == null || value.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre de la actividad no puede estar vacío");
        }
        this.m_strNombre = value;
    }

    private void setTipoDieta(TipoDieta value) throws DatosInvalidosException {
        if (value == null) {
            throw new DatosInvalidosException("El tipo de dieta no puede ser nulo");
        }
        this.m_eTipoDieta = value;
    }

    // Constructor
    public Actividad(String p_strNombre, TipoDieta p_eTipoDieta) throws DatosInvalidosException {
        setNombreActividad(p_strNombre);
        setTipoDieta(p_eTipoDieta);
    }

    @Override
    public String toString() {
        return "Actividad --> Nombre: " + this.m_strNombre + " | Tipo Dieta: " + this.m_eTipoDieta + ".";
    }
}
