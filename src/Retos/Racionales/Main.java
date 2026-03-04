package Retos.Racionales;

public class Main {

    public static void main(String[] args) {

        try {
            // Ejercicio 8
            Racional castillo;
            castillo = new Racional(3, 5);
            castillo.res(new Racional(1, 4));
            castillo.sum(new Racional(1, 10));
            castillo.mul(new Racional(3, 2));
            castillo.res(new Racional(1, 5));
            Racional divisor;
            divisor = new Racional(2, 6);
            divisor.sum(new Racional(1, 3));
            divisor.res(new Racional(6, 4));
            divisor.div(new Racional(2, 3));
            divisor.sum(new Racional(1, 6));
            castillo.div(divisor);
            System.out.println("Resultado Final: " + castillo);

            // Ejercicio 13
            Racional racional = new Racional(2, 4);
            System.out.println("2/4 simplificado es: " + racional);

        } catch (DatoInvalidoException die) {
            System.out.println(die.getMessage());
        } catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR INESPERADO.");
        }
    }
}
