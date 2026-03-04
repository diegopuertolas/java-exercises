package Ejercicios.Colecciones.Pilas;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> pila = new Stack<>();
        for (int i = 0; i <= 10; i++) {
            pila.push(i);
        }
        while (!pila.empty()) {
            System.out.println(pila.pop());
        }
    }
}
