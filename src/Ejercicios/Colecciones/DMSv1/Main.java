package Ejercicios.Colecciones.DMSv1;

import Ejercicios.Colecciones.DMSv1.enums.Periodo;
import Ejercicios.Colecciones.DMSv1.exceptions.DatosInvalidosException;
import Ejercicios.Colecciones.DMSv1.models.Carnivoro;
import Ejercicios.Colecciones.DMSv1.models.Dinosaurio;
import Ejercicios.Colecciones.DMSv1.models.Herbivoro;
import Ejercicios.Colecciones.DMSv1.services.GestorParque;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Herramientas
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        GestorParque<Dinosaurio> gestorParque = new GestorParque<>();

        boolean bSalir = false;
        do {

            mostrarMenu();
            int iOpcion = leerInt("\nEliga una opción: ");

            switch (iOpcion) {
                case 1:
                    addDinosaurioOpcion(gestorParque);
                    break;
                case 2:
                    mostrarTodosOpcion(gestorParque);
                    break;
                case 3:
                    listarPorPeriodoOpcion(gestorParque);
                    break;
                case 4:
                    mostrarAtraccionEstrellaOpcion(gestorParque);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    bSalir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");

            }
        } while (!bSalir);

    }

    /**
     * Método para mostrar el menú de opciones por pantalla.
     */
    private static void mostrarMenu() {
        System.out.println("--- Bienvenido a Dinópolis ---");
        System.out.println("Eliga una de las opciones: ");
        System.out.println(" - 1: Añadir dinosaurio al sistema.");
        System.out.println(" - 2: Mostrar todos los dinosaurios con información detallada.");
        System.out.println(" - 3: Listar dinosaurios por periodo.");
        System.out.println(" - 4: Mostrar el dinosaurio más grande (atracción estrella).");
        System.out.println(" - 5: Fin del programa");
    }

    private static void addDinosaurioOpcion(GestorParque<Dinosaurio> p_gestorParque) {
        boolean bSalir = false;
        int iTipo = 0;
        do {
            iTipo = leerInt("Introduzca el tipo (1. Carnivoro / 2. Herbivoro): ");
            if (iTipo == 1 || iTipo == 2)  {
                System.out.println("Tipo elegido correctamente.");
                bSalir = true;
            } else {
                System.out.println("Eliga entre los dos tipos permitidos.");
            }
        } while (!bSalir);

        System.out.print("Introduzca el nombre: ");
        String strNombre = sc.nextLine();

        double dbSize = leerDouble("Introduzca el tamaño: ");

        Periodo ePeriodo = leerPeriodo();

        try {
            Dinosaurio nuevoDinosaurio;

            if (iTipo == 1) {
                nuevoDinosaurio = new Carnivoro(strNombre, dbSize, ePeriodo);
            } else {
                nuevoDinosaurio = new Herbivoro(strNombre, dbSize, ePeriodo);
            }

            p_gestorParque.addDinosaurio(nuevoDinosaurio);
            System.out.println("Dinosaurio añadido al parque!");

        } catch (DatosInvalidosException die) {
            // 3. Si meten un tamaño negativo o nombre vacío, lo cazamos aquí
            System.out.println(die.getMessage());
        }

    }

    private static void mostrarTodosOpcion(GestorParque<Dinosaurio> p_gestorParque) {
        List<Dinosaurio> lstDinosaurios = p_gestorParque.getAll();

        if (lstDinosaurios.isEmpty()) {
            System.out.println("El parque está vacío.");
            return;
        }

        for (Dinosaurio dinosaurio : lstDinosaurios) {
            dinosaurio.mostrarInformacion();
        }

    }

    private static void listarPorPeriodoOpcion(GestorParque<Dinosaurio> p_gestorParque) {
        Periodo ePeriodo = leerPeriodo();

        List<Dinosaurio> lstResultados = p_gestorParque.buscarPorPeriodo(ePeriodo);

        if (lstResultados.isEmpty()) {
            System.out.println("No hay dinosaurios registrados.");
            return;
        }
        System.out.println("\n\rResultados del periodo " + ePeriodo + ":");
        for (Dinosaurio dino : lstResultados) {
            dino.mostrarInformacion();
        }
    }

    private static void mostrarAtraccionEstrellaOpcion(GestorParque<Dinosaurio> p_gestorParque) {
        Dinosaurio dinosaurioMasGrande = p_gestorParque.obtenerMasGrande();

        if (dinosaurioMasGrande == null) {
            System.out.println("Aún no hay dinosaurios!");
        } else {
            dinosaurioMasGrande.atraccionEstrella();
        }
    }

    /**
     * Método para leer un int y lanzar excepción en caso de que no lo sea.
     * @param strMensaje String
     * @return iDato
     */
    public static int leerInt(String strMensaje)  {
        int iDato = 0;
        boolean bRet = false;
        do {
            try {
                System.out.print(strMensaje);
                iDato = sc.nextInt();
                sc.nextLine();
                bRet = true;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("\nIntroduzca un número entero.");
            }
        } while (!bRet);

        return iDato;
    }

    /**
     * Método para leer un double y lanzar excepción en caso de que no lo sea.
     * @param strMensaje String
     * @return dbDato
     */
    public static double leerDouble(String strMensaje) {
        double dbDato = 0;
        boolean bRet = false;
        do {
            try {
                System.out.print(strMensaje);
                dbDato = sc.nextDouble();
                sc.nextLine();
                bRet = true;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("\nIntroduzca un número decimal");
            }
        } while (!bRet);

        return dbDato;
    }

    /**
     * Método para leer el periodo.
     * @return El periodo elegido.
     */
    private static Periodo leerPeriodo() {
        boolean bSalir = false;
        int iOpcion;
        Periodo ePeriodoSeleccionado = null;
        do {
            System.out.println("Seleccione el periodo:");
            System.out.println("1. Triásico");
            System.out.println("2. Jurásico");
            System.out.println("3. Cretácico");
            iOpcion = leerInt("Eliga una opción: ");

            switch (iOpcion) {
                case 1:
                    ePeriodoSeleccionado = Periodo.TRIASICO;
                    bSalir = true;
                    break;
                case 2:
                    ePeriodoSeleccionado = Periodo.JURASICO;
                    bSalir = true;
                    break;
                case 3:
                    ePeriodoSeleccionado = Periodo.CRETACICO;
                    bSalir = true;
                    break;
                default:
                    System.out.println("\n\rOpción inválida.");
                    break;
            }
        } while (!bSalir);

        return ePeriodoSeleccionado;
    }

}
