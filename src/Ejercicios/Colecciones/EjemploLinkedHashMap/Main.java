package Ejercicios.Colecciones.EjemploLinkedHashMap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();

        linkedHashMap.put(1, "Casillas");
        linkedHashMap.put(2, "Villa");
        linkedHashMap.put(3, "Iniesta");
        linkedHashMap.put(4, "Xavi");
        linkedHashMap.put(5, "Busquets");
        linkedHashMap.put(6, "Pyol");


        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            System.out.println("Clave: " + key + " -> Valor: " + linkedHashMap.get(key));
        }


        for (Integer key : linkedHashMap.keySet()) {
            System.out.println("Clave: " + key + "Valor: " + linkedHashMap.get(key));
        }


    }
}
