package Retos.PruebaAutoria;

public class Main {
    private static final int SIZE = 4;

    public static void main(String[] args) {

        GestorEmbarque gestorEmbarque = new GestorEmbarque();

        IPasajero[] arrPasajeros = new IPasajero[SIZE];
        arrPasajeros[0] = new Pasajero("Caneli",12, "W123456");
        arrPasajeros[1] = new Pasajero("MT", 18, "U882821");
        arrPasajeros[2] = new PasajeroVIP("Adri", 2, "P228826", 12271, 100 );
        arrPasajeros[3] = new Pasajero("Javi", 67, "X17272");

        for (int i = 0; i < SIZE; i++) {
            gestorEmbarque.agregarAFila(arrPasajeros[i]);
        }

        gestorEmbarque.procesarEmbarque();

        System.out.println(gestorEmbarque.getVueloDestino().toString());
        System.out.println(gestorEmbarque.getProblemasDocumentacion().toString());

    }
}