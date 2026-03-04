package Ejercicios.Colecciones.DMSv2.services;

import Ejercicios.Colecciones.DMSv2.enums.Periodo;
import Ejercicios.Colecciones.DMSv2.enums.TipoDieta;
import Ejercicios.Colecciones.DMSv2.exceptions.ActividadInvalidaException;
import Ejercicios.Colecciones.DMSv2.exceptions.DatosInvalidosException;
import Ejercicios.Colecciones.DMSv2.exceptions.DinosaurioNoEncontradoException;
import Ejercicios.Colecciones.DMSv2.model.Carnivoro;
import Ejercicios.Colecciones.DMSv2.model.Dinosaurio;
import Ejercicios.Colecciones.DMSv2.model.Actividad;
import Ejercicios.Colecciones.DMSv2.model.Herbivoro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorParque<T extends Dinosaurio > {

    // Constantes
    private static final int MAX_ACTIVIDADES_DIA = 10;

    // Propiedades
    private List<T> m_lstDinosaurios;
    private int m_iNumeroActividadesDiarias;

    // Constructor
    public GestorParque() {
        this.m_lstDinosaurios = new ArrayList<>();
        this.m_iNumeroActividadesDiarias = 0;
    }

    /**
     * Añade un nuevo dinosaurio al gestor.
     * @param p_dinosaurio El dinosaurio a añadir.
     * @throws DatosInvalidosException Si el dinosaurio es nulo.
     */
    public void addDinosaurio(T p_dinosaurio) throws DatosInvalidosException {
        if (p_dinosaurio == null) throw new DatosInvalidosException("No se puede añadir un animal nulo");
        this.m_lstDinosaurios.add(p_dinosaurio);
    }

    /**
     * Devuelve todos los dinosaurios que vivieron en un periodo específico.
     * @param p_ePeriodo El periodo a buscar.
     * @return Una lista con los dinosaurios encontrados.
     */
    public List<T> buscarPorPeriodo(Periodo p_ePeriodo) {
        List<T> lstResultados = new ArrayList<>();

        for (T dinosaurioActual : this.m_lstDinosaurios) {
            if (dinosaurioActual.getPeriodo() == p_ePeriodo) {
                lstResultados.add(dinosaurioActual);
            }
        }

        return lstResultados;
    }

    /**
     * Obtiene el dinosaurio de mayor tamaño registrado en el gestor del parque.
     * @return El dinosaurio más grande o null si la lista está vacía.
     */
    public T obtenerMasGrande() {
        if (this.m_lstDinosaurios.isEmpty()) return null;

        T dinosaurioMasGrande = this.m_lstDinosaurios.getFirst();

        for (T dinosaurioActual : this.m_lstDinosaurios) {
            if (dinosaurioActual.getSize() > dinosaurioMasGrande.getSize()) {
                dinosaurioMasGrande = dinosaurioActual;
            }
        }

        return dinosaurioMasGrande;
    }

    /**
     * Devuelve la lista completa de dinosaurios.
     * @return Lista inmodificable de todos los dinosaurios.
     */
    public List<T> getAll() {
        return Collections.unmodifiableList(this.m_lstDinosaurios);
    }

    /**
     * Devuelve los datos del dinosaurio que coinciden con el nombre que pasamos como argumento.
     * @param p_strNombre Nombre del dinosaurio que queremos buscar.
     * @return Los datos del dinosaurio encontrado
     * @throws IllegalArgumentException Si el nombre es nulo o está vacío.
     * @throws IllegalStateException Si la lista de dinosaurios está vacía.
     * @throws DinosaurioNoEncontradoException Si no se ha encontrado a ningún dinosaurio con el mismo nombre.
     */
    public T buscarPorNombre(String p_strNombre) throws DinosaurioNoEncontradoException {
        if (p_strNombre == null || p_strNombre.trim().isEmpty()) throw new IllegalArgumentException("El nombre de búsqueda no puede estar vacío.");
        if (this.m_lstDinosaurios.isEmpty()) throw new IllegalStateException("La lista de dinosaurios está vacía.");

        for (T dinosaurioActual : this.m_lstDinosaurios) {
            if (dinosaurioActual.getNombre().equalsIgnoreCase(p_strNombre)) {
                return dinosaurioActual;
            }
        }

        throw new DinosaurioNoEncontradoException("El dinosaurio " + p_strNombre + " no ha sido encontrado");
    }

    /**
     * Asigna una actividad a un dinosaurio, para ello comprueba si el número de actividades díarias
     * no ha superado el máximo y sí el tipo del dinosaurio es compatible con la actividad.
     * @param p_dinosaurio El dinosaurio a asignar actividad.
     * @param p_actividad La actividad a asignar.
     * @throws IllegalArgumentException Si el dinosaurio o la actividad son nulas.
     * @throws IllegalStateException Si se ha superado el límite máximo de actividades.
     * @throws ActividadInvalidaException Si el tipo del dinosaurio es incompatible con la actividad.
     */
    public void asignarActividad(T p_dinosaurio, Actividad p_actividad) throws ActividadInvalidaException {
        if (p_dinosaurio == null || p_actividad == null) throw new IllegalArgumentException("El dinosaurio o la actividad no pueden ser nulos.");
        if (m_iNumeroActividadesDiarias >= MAX_ACTIVIDADES_DIA) throw new IllegalStateException("Has superado el límite máximo de actividades díarias.");

        boolean bEsCompatible = false;

        if (p_dinosaurio instanceof Carnivoro && p_actividad.getTipoDieta() == TipoDieta.CARNIVORO) {
            bEsCompatible = true;
        } else if (p_dinosaurio instanceof Herbivoro && p_actividad.getTipoDieta() == TipoDieta.HERBIVORO) {
            bEsCompatible = true;
        }

        if (!bEsCompatible) {
            throw new ActividadInvalidaException("Actividad incompatible");
        }
        m_iNumeroActividadesDiarias++;
        System.out.println("Actividad: " + p_actividad.getNombreActividad() + ", añadida con éxito a " + p_dinosaurio.getNombre() + ".");
    }
}
