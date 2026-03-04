package Ejercicios.Colecciones.PracticaArrayList;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Crea una lista que contenga los días de la semana.
        List<String> listDias = new ArrayList<>();
        listDias.add("Lunes");
        listDias.add("Martes");
        listDias.add("Miércoles");
        listDias.add("Jueves");
        listDias.add("Viernes");
        listDias.add("Sábado");
        listDias.add("Domingo");
        System.out.println("\nLista que contiene los dias de la semana");
        System.out.println(listDias);

        // Inserta en la posición 4 el elemento «Juernes».
        listDias.add(3, "Juernes");
        System.out.println("\nInserta en la posición 4 el elemento «Juernes»");
        System.out.println(listDias);

        // Copia esa lista a otra llamada listaDos.
        List<String> listDos = new ArrayList<>(listDias);
        System.out.println("\nCopia esa lista a otra llamada listaDos");
        System.out.println("listDos: " + listDos);

        // Añade a listDias el contenido de listaDos.
        listDias.addAll(listDos);
        System.out.println("\nAñade a listDias el contenido de listaDos");
        System.out.println(listDias);

        // Muestra el contenido de las posiciones 3 y 4 de la lista original
        System.out.println("\nMuestra el contenido de las posiciones 3 y 4 de la lista original");
        System.out.println(listDias.get(3) + " " + listDias.get(4));

        // Muestra el primer elemento y el último de la lista original
        System.out.println("\nMuestra el primer elemento y el último de la lista original");
        System.out.println(listDias.getFirst() + " " + listDias.getLast());

        // LinkedList J.17 !!!!!

        // Elimina el elemento que contenga «Juernes» de la lista y comprueba si elimina algo o no.
        System.out.println("\nElimina el elemento que contenga «Juernes» de la lista y comprueba si elimina algo o no.");
        if (listDias.remove("Juernes")) { // Como hay dos Juernes, solo borrará el primero.
            System.out.println("Borrado");
        } else {
            System.out.println("No existe");
        }
        System.out.println(listDias);

        // Crea un iterator y muestra uno a uno los valores de la lista original.
        System.out.println("\nCrea un iterator y muestra uno a uno los valores de la lista origina");
        Iterator<String> it = listDias.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Busca si existe en la lista un elemento que se denomine "Lunes"
        System.out.println("\nBusca si existe en la lista un elemento que se denomine \"Lunes\"");
        if (listDias.contains("Lunes")) {
            System.out.println("Contiene Lunes");
        } else {
            System.out.println("No contiene Lunes");
        }

        // Busca si existe en la lista un elemento que se denomine «Lunes». No importa si está en mayúscula o minúscula.
        System.out.println("\nBusca si existe en la lista un elemento que se denomine «Lunes». No importa si está en mayúscula o minúscula");
        boolean bEncontrado = false;
        for (String dia : listDias) {
            if (dia.equalsIgnoreCase("Lunes")) {
                bEncontrado = true;
                break;
            }
        }

        if (bEncontrado) {
            System.out.println("Encontrado");
        } else {
            System.out.println("No encontrado");
        }

        // Ordena la lista y muestra su contenido.
        System.out.println("\nOrdena la lista y muestra su contenido");
        Collections.sort(listDias);
        System.out.println(listDias);

        // Borra todos los elementos de la lista.
        System.out.println("\nBorra todos los elementos de la lista");
        listDias.clear();
        System.out.println(listDias);

    }
}
