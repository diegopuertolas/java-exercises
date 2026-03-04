package Retos.MarcusGym.models;

import Ejercicios.Colecciones.DMSv2.exceptions.DatosInvalidosException;
import Retos.MarcusGym.enums.Especialidad;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Entrenador extends Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // Propiedades
    private Especialidad m_eEspecialidad;
    private double m_dbSueldoBase;

    // Métodos Get y Set
    public Especialidad getEspecialidad() {
        return m_eEspecialidad;
    }

    private void setEspecialidad(Especialidad value) throws DatosInvalidosException {
        if (value == null) throw new DatosInvalidosException("La especialidad no puede ser nula.");
        this.m_eEspecialidad = value;
    }

    public double getSueldoBase() {
        return m_dbSueldoBase;
    }

    private void setSueldoBase(double value) throws DatosInvalidosException {
        if (value <= 0) throw new DatosInvalidosException("El sueldo no puede ser negativa o igual a 0");
        this.m_dbSueldoBase = value;
    }

    // Constructor con parámetros
    public Entrenador(String p_strDNI, String p_strNombre, String p_strApellidos, int p_iEdad,
                      Especialidad p_eEspecialidad, double p_dbSueldoBase ) throws DatosInvalidosException
    {
        super(p_strDNI, p_strNombre, p_strApellidos, p_iEdad);
        setEspecialidad(p_eEspecialidad);
        setSueldoBase(p_dbSueldoBase);
    }


    @Override
    public String mostrarRutina() {
        return "Metele caña a la rutina " + getEspecialidad() + ".";
    }

    @Override
    public String toString() {
        return super.toString() + " | Especialidad: " + getEspecialidad() + " | Sueldo Base: " + getSueldoBase() + "€";
    }

}
