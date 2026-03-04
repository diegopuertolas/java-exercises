package Retos.GestionElectrodomesticos;

public class Main {

    public static void main(String[] args) {

        // Creamos el array de los electrodomésticos.
        Electrodomestico[] arrElectrodomestico = new Electrodomestico[10];

        try {
            // Llenamos el array.
            arrElectrodomestico[0] = new Lavadora(200, 'A', "Azul", 40, 35);
            arrElectrodomestico[1] = new Television(500, 'B', "Negro", 10, 50, true);
            arrElectrodomestico[2] = new Electrodomestico(150, 'A', "Gris", 10);
            arrElectrodomestico[3] = new Lavadora(100, 15);
            arrElectrodomestico[4] = new Television(250, 5);
            arrElectrodomestico[5] = new Lavadora(300, 'F', "Blanco", 60, 10);
            arrElectrodomestico[6] = new Television(800, 'A', "Rojo", 30, 65, false);
            arrElectrodomestico[7] = new Electrodomestico(); // Valores por defecto
            arrElectrodomestico[8] = new Lavadora(180, 'D', "Negro", 50, 40);
            arrElectrodomestico[9] = new Television(120, 'E', "Gris", 12, 32, true);

        } catch (DatoInvalidoException die) {
            System.out.println(die.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR INESPERADO.");
        }

        double dbSumaElectrodomesticos = 0;
        double dbSumaLavadoras = 0;
        double dbSumaTelevisiones = 0;

        for (Electrodomestico electrodomestico : arrElectrodomestico) {
            // Verificamos que no sea null, por si se lanzó alguna excepción en el bloque del try and catch, para evitar la excepción NullPointerException.
            if (electrodomestico != null) {
                double dbPrecio = electrodomestico.precioFinal();
                dbSumaElectrodomesticos += dbPrecio;

                if (electrodomestico instanceof Lavadora) {
                    dbSumaLavadoras += dbPrecio;
                } else if (electrodomestico instanceof Television) {
                    dbSumaTelevisiones += dbPrecio;
                }
            }
        }

        System.out.println("Suma total de Electrodomésticos: " + dbSumaElectrodomesticos + " €");
        System.out.println("Suma total de Lavadoras: " + dbSumaLavadoras + " €");
        System.out.println("Suma total de Televisiones: " + dbSumaTelevisiones + " €");
    }
}
