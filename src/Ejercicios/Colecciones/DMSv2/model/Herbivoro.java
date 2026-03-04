package Ejercicios.Colecciones.DMSv2.model;

import Ejercicios.Colecciones.DMSv2.enums.Periodo;
import Ejercicios.Colecciones.DMSv2.exceptions.DatosInvalidosException;

public class Herbivoro extends Dinosaurio {

    // Constructor con parámetros
    public Herbivoro(String p_strNombre, double p_dbSize, Periodo p_ePeriodo) throws DatosInvalidosException {
        super(p_strNombre, p_dbSize, p_ePeriodo);
    }

    @Override
    public String rugir() {
        return "Mmmmuuuuhhhh";
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Dieta: Herbivoro");
    }
}
