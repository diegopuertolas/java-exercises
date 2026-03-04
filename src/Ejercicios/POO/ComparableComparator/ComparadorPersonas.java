package Ejercicios.POO.ComparableComparator;

import java.util.Comparator;

public class ComparadorPersonas implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Persona p1 = (Persona) o1;
        Persona p2 = (Persona) o2;

        return p1.getNombre().compareToIgnoreCase(p2.getNombre());
    }
}
