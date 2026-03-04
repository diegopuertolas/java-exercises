package Ejercicios.POO.ImplementacionInterfazI;

/**
 * Interfaz que define las relaciones entre dos objetos.
 * <p>
 * Cualquier clase que implemente esta interfaz debe definir la lógica
 * para saber si un objeto es mayor, menor o igual que otro.
 * </p>
 *
 * @author Diego Puértolas Ruiz
 */
public interface IRelaciones {

    /**
     * Comprueba si el objeto actual es mayor que el objeto proporcionado.
     *
     * @param b Objeto con el que se va a comparar el objeto actual.
     * @return {@code true} si este objeto es mayor que b; {@code false} en caso contrario
     * o si el objeto b no es del mismo tipo.
     */
    boolean esMayor(Object b);

    /**
     * Comprueba si el objeto actual es menor que el objeto proporcionado.
     *
     * @param b Objeto con el que se va a comparar el objeto actual.
     * @return {@code true} si este objeto es menor que b; {@code false} en caso contrario
     * o si el objeto b no es del mismo tipo.
     */
    boolean esMenor(Object b);

    /**
     * Comprueba si el objeto actual es igual que el objeto proporcionado.
     *
     * @param b Objeto con el que se va a comparar el objeto actual.
     * @return {@code true} si este objeto es igual que b; {@code false} en caso contrario
     * o si el objeto b no es del mismo tipo.
     */
    boolean esIgual(Object b);

}
