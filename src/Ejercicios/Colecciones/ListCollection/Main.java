package Ejercicios.Colecciones.ListCollection;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Por defecto lo crea con 10 elementos, si no le decimos de cuanto.
        ArrayList<String> arrList = new ArrayList<>();

        arrList.add("Hola");
        arrList.add("Adios");

        System.out.println(arrList.toString());

        String[] arrPrimeraEvaluacion = {"cuatro", "cinco", "seis"};
        ArrayList<String> arrSegundaEvalucacion = new ArrayList<>(Arrays.asList(arrPrimeraEvaluacion));
        System.out.println(arrSegundaEvalucacion.toString());

        for (String str: arrPrimeraEvaluacion) {
            System.out.println(str);
        }

        LinkedList<String> listaDoble = new LinkedList<>();
        listaDoble.add("Hola");
        listaDoble.add(1, "Adios");
        System.out.println(listaDoble.toString());

        // Recorrer la colección. NO PODEMOS ELIMINAR ELEMENTOS MIENTRAS LOS RECORREMOS EN UN FOR EACH,
        // SOLO HACEMOS ESO USANDO EL ITERATOR
        // ITERACIÓN --> Siempre hacia delante, me permite recorrerlo como si fuese una lista doblemente enlazada.
        Iterator<String> it = listaDoble.iterator();
        while (it.hasNext()) {
            String cadena = it.next();
            if (cadena.equals("Adios")) {
                it.remove();
            }
            System.out.println(it.next());
        }



        // Podemos decidir desde que posicion lo quiero iterar, tenemos previous y next
        ListIterator<String> dit = listaDoble.listIterator(listaDoble.size());
        while(dit.hasPrevious()) {
            System.out.println(dit.previous());
        }

        Iterator<String> it3 = listaDoble.descendingIterator();
        while (it3.hasNext()) {
            System.out.println(it3.next());
        }

        // ArrayList<>
        // LinkedList<>
        // List : similar a array list

        // Iterator


        // FOR EACH
        for (String cadena: listaDoble) {
            if (cadena.equals("Adios")) {
                listaDoble.remove(cadena);
            }
            System.out.println(cadena);
        }
    }
}
