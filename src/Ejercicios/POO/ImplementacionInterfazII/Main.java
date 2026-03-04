package Ejercicios.POO.ImplementacionInterfazII;

public class Main {

    public static void main(String[] args) {

        IFigura[] figuras = new IFigura[5];

        try {
            figuras[0] = new Circulo(12.25);
            figuras[1] = new Rectangulo(15.00, 20.00);
            figuras[2] = new Triangulo(5, 3);
            figuras[3] = new Rectangulo(98, 122);
            figuras[4] = new Circulo(45);

            for (IFigura figura : figuras) {
                System.out.println("Figura: " + figura.getClass().getSimpleName());
                System.out.printf(" - Área:      %.2f\r\n", figura.getArea());
                System.out.printf(" - Perímetro: %.2f\r\n", figura.getPerimetro());
                System.out.println("-----------------------");
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
