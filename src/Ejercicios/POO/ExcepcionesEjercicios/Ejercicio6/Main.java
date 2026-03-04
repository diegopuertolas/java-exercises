package Ejercicios.POO.ExcepcionesEjercicios.Ejercicio6;

public class Main {

    public static void main(String[] args) {

        try  {
            System.out.println("\r\nPrueba datos correctos: ");
            Gato g1 = new Gato("Diego", 19);
            g1.imprimir();
        } catch (DatoInvalidoException die) {
            System.out.println(die.getMessage());
        }

        try  {
            System.out.println("\r\nPrueba nombre incorrecto: ");
            Gato g2 = new Gato("An", 19);
            g2.imprimir();
        } catch (DatoInvalidoException die) {
            System.out.println(die.getMessage());
        }

        try  {
            System.out.println("\r\nPrueba edad incorrecta: ");
            Gato g3 = new Gato("Pepe", -12);
            g3.imprimir();
        } catch (DatoInvalidoException die) {
            System.out.println(die.getMessage());
        }

        try  {
            System.out.println("\r\nPrueba de modificar datos con el set: ");
            Gato g4 = new Gato("David", 78);
            g4.imprimir();

            g4.setNombre(null);

        } catch (DatoInvalidoException die) {
            System.out.println(die.getMessage());
        }


    }
}
