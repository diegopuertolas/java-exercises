package Ejercicios.Colecciones.EjemploHashMap;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, String> m = new HashMap<Integer, String>();

        m.put(1, "Diego");
        m.put(2, "Canelita");
        m.put(3, "MT");
        m.put(4, "Adri");
        m.put(5, "Habibi");

        System.out.println("Los elementos del mapa 'm' son: ");
        System.out.println(m.get(1));
        System.out.println(m.get(2));
        System.out.println(m.get(3));
        System.out.println(m.get(4));
        System.out.println(m.get(5));

        System.out.println("Todas las entradas del diccionario con entrySet(): ");
        System.out.println(m.entrySet());

        System.out.println("Entradas del diccionario una a una: ");
        for (Map.Entry pareja : m.entrySet()) {
            System.out.println(pareja);
        }

        for (Map.Entry pareja : m.entrySet()) {
            System.out.println(pareja.getKey() + " | " + pareja.getValue());
        }

    }
}
