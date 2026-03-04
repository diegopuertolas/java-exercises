package Ejercicios.POO.EjercicioClaseAbstracta;

public class Senador extends Legislador {

    // Constructor con parámetros
    public Senador(String p_strNombre, String p_strProvinciaQueRepresenta) {
        super(p_strNombre, p_strProvinciaQueRepresenta);
    }

    /**
     * {@inheritDoc}
     * <p>
     * En este caso, devuelve siempre "Senado".
     * </p>
     */
    @Override
    public String getCamaraEnQueTrabaja() {
        return "Senado";
    }

}
