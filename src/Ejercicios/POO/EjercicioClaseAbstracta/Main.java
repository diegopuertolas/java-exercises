package Ejercicios.POO.EjercicioClaseAbstracta;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {
            // Usamos un ArrayList, ya que no se nos pide una cantidad concreta de legisládores.
            ArrayList<Legislador> arrParlamento = new ArrayList<>();

            arrParlamento.add(new Diputado("Juan", "Zaragoza"));
            arrParlamento.add(new Senador("Maria", "Huesca"));
            arrParlamento.add(new Diputado("Luis", "Teruel"));

            // Legislador[] arrLegisladores = new Legisladores[<longitud del array>];
            //  - arrLegisladores[0] = new Diputado(...);
            //  - arrLegisladores[1] = new Senador(...)
            //  ...
            //  - arrLegisladores[n] = new Diputado(...);

            for (Legislador legislador : arrParlamento) {
                System.out.println(legislador.getNombre() + ", de la provincia de " + legislador.getProvinciaQueRepresenta());
                System.out.println(legislador.getCamaraEnQueTrabaja() + "\r\n");
                System.out.println("-----\r\n");
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
