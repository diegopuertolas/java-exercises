package Ejercicios.Colecciones.DMSv1.services;

import Ejercicios.Colecciones.DMSv1.enums.Periodo;
import Ejercicios.Colecciones.DMSv1.exceptions.DatosInvalidosException;
import Ejercicios.Colecciones.DMSv1.models.Dinosaurio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorParque<T extends Dinosaurio> {

    // Propiedades
    private List<T> m_lstDinosaurios;

    // Constructor
    public GestorParque() {
        this.m_lstDinosaurios = new ArrayList<>();
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

        T dinosaurioMasGrande = this.m_lstDinosaurios.get(0);

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
}
