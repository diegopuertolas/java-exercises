package Ejercicios.POO.ImplementacionInterfazII;

/**
 * Interfaz que define el comportamiento básico de una figura geométrica.
 *
 * <p>
 * Cualquier clase que represente una figura (triángulo, círculo, etc.) debe implementar
 * esta interfaz para asegurar que puede calcular sus dimensiones básicas.
 * </p>
 *
 * @author Diego Puértolas Ruiz
 */
public interface IFigura {

    /**
     * Calcula el perímetro de la figura geométrica.
     *
     * @return double Valor numérico del perímetro.
     */
    double getPerimetro();

    /**
     * Calcula el área de la figura geométrica.
     *
     * @return double Valor numérico del área total contenida en la figura.
     */
    double getArea();

}
