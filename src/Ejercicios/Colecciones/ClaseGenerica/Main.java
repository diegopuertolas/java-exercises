package Ejercicios.Colecciones.ClaseGenerica;

public class Main {

    public static void main(String[] args) {

        Dos<String> cadenasDos = new Dos<>("primero", "segundo");
        Dos<Integer> integerDos1 = new Dos<>(4, 9);
        Dos<Integer> integerDos2 = new Dos<>(4, 9);

        String v1 = cadenasDos.getPrimero();
        String v2 = cadenasDos.getSegundo();
        int i1 = integerDos1.getPrimero();
        int i2 = integerDos1.getSegundo();
        integerDos2.setPrimero(10);
        integerDos2.setSegundo(2);

        System.out.println(cadenasDos);
        System.out.println(integerDos1);
        System.out.println(integerDos2);

    }
}
