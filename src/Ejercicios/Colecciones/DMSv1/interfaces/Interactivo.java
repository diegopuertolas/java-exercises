package Ejercicios.Colecciones.DMSv1.interfaces;

/**
 * Interfaz que define el contrato para las entidades interactivas del parque Dinópolis.
 * <p>
 * Cualquier clase que implemente esta interfaz estará obligada
 * a proporcionar el comportamiento necesario para mostrar sus datos al público
 * y destacar como atracción principal.
 * </p>
 */
public interface Interactivo {

    /**
     * Muestra por consola la información detallada de un dinosaurio.
     */
    void mostrarInformacion();

    /**
     * Destaca a los dinosaurios más populares en el parque.
     */
    void atraccionEstrella();

}