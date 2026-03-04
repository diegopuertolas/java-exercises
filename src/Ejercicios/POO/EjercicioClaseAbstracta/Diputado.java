package Ejercicios.POO.EjercicioClaseAbstracta;

public class Diputado extends Legislador {

    // Constructor con parámetros
    public Diputado(String p_strNombre, String p_strProvinciaQueRepresenta) {
        super(p_strNombre, p_strProvinciaQueRepresenta);
    }

    /**
     * {@inheritDoc}
     * <p>
     * En este caso, devuelve siempre "Congreso de los Diputados".
     * </p>
     */
    @Override
    public String getCamaraEnQueTrabaja() {
        return "Congreso de los Diputados";
    }

}

// CLASE CON EXTENDS CON VARIAS INTERFACES