package Ejercicios.Colecciones.DMSv2;

import Ejercicios.Colecciones.DMSv2.enums.Periodo;
import Ejercicios.Colecciones.DMSv2.enums.TipoDieta;
import Ejercicios.Colecciones.DMSv2.exceptions.ActividadInvalidaException;
import Ejercicios.Colecciones.DMSv2.exceptions.DatosInvalidosException;
import Ejercicios.Colecciones.DMSv2.exceptions.DinosaurioNoEncontradoException;
import Ejercicios.Colecciones.DMSv2.model.Actividad;
import Ejercicios.Colecciones.DMSv2.model.Carnivoro;
import Ejercicios.Colecciones.DMSv2.model.Dinosaurio;
import Ejercicios.Colecciones.DMSv2.model.Herbivoro;
import Ejercicios.Colecciones.DMSv2.services.GestorParque;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Herramientas
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        GestorParque<Dinosaurio> gestorParque = new GestorParque<>();
        ArrayList<Actividad> lstActividades = new ArrayList<>();

        boolean bSalir = false;
        do {

            mostrarMenu();
            int iOpcion = leerInt("\nElija una opción: ");

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
                    buscarPorNombreOpcion(gestorParque);
                    break;
                case 6:
                    crearActividadOpcion(lstActividades);
                    break;
                case 7:
                    asignarActividadOpcion(gestorParque, lstActividades);
                    break;
                case 8:
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
        System.out.println("Elija una de las opciones: ");
        System.out.println(" - 1: Añadir dinosaurio al sistema.");
        System.out.println(" - 2: Mostrar todos los dinosaurios con información detallada.");
        System.out.println(" - 3: Listar dinosaurios por periodo.");
        System.out.println(" - 4: Mostrar el dinosaurio más grande (atracción estrella).");
        System.out.println(" - 5: Buscar dinosaurio por nombre.");
        System.out.println(" - 6: Crear Actividad.");
        System.out.println(" - 7: Asignar actividad.");
        System.out.println(" - 8: Fin del programa.");
    }

    /**
     * Opción interactiva para registrar un nuevo dinosaurio en el parque.
     * Solicita los datos al usuario y el gestor añade al dinosaurio al registro.
     * @param p_gestorParque El gestor principal del parque.
     */
    private static void addDinosaurioOpcion(GestorParque<Dinosaurio> p_gestorParque) {
        boolean bSalir = false;
        int iTipo;
        do {
            iTipo = leerInt("Introduzca el tipo (1. Carnivoro / 2. Herbivoro): ");
            if (iTipo == 1 || iTipo == 2)  {
                System.out.println("Tipo elegido correctamente.");
                bSalir = true;
            } else {
                System.out.println("Elija entre los dos tipos permitidos.");
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
            System.out.println(die.getMessage());
        }

    }

    /**
     * Opción para mostrar por pantalla la información detallada de todos los dinosaurios registrados.
     * @param p_gestorParque El gestor principal del parque.
     */
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

    /**
     * Opción interactiva para listar a los dinosaurios por periodo.
     * Solicita los datos del periodo al usuario mediante un método auxiliar
     * y el gestor lista todos los dinosaurios que pertenecen a dicho periodo.
     * @param p_gestorParque El gestor principal del parque.
     */
    private static void listarPorPeriodoOpcion(GestorParque<Dinosaurio> p_gestorParque) {
        Periodo ePeriodo = leerPeriodo();

        List<Dinosaurio> lstResultados = p_gestorParque.buscarPorPeriodo(ePeriodo);

        if (lstResultados.isEmpty()) {
            System.out.println("No hay dinosaurios registrados.");
            return;
        }
        System.out.println("\nResultados del periodo " + ePeriodo + ":");
        for (Dinosaurio dino : lstResultados) {
            dino.mostrarInformacion();
        }
    }

    /**
     * Opción para calcular y mostrar cuál es el dinosaurio estrella del parque, es decir, el
     * de mayor tamaño.
     * @param p_gestorParque El gestor principal del parque.
     */
    private static void mostrarAtraccionEstrellaOpcion(GestorParque<Dinosaurio> p_gestorParque) {
        Dinosaurio dinosaurioMasGrande = p_gestorParque.obtenerMasGrande();

        if (dinosaurioMasGrande == null) {
            System.out.println("Aún no hay dinosaurios!");
        } else {
            dinosaurioMasGrande.atraccionEstrella();
        }
    }

    /**
     * Opción interactiva para buscar dinosaurios por su nombre.
     * Solicita al usuario el nombre del dinosaurio a buscar y el gestor se
     * encarga de buscar a los dinosaurios que coincidan con el nombre.
     * Gestiona las excepciones en caso de no encontrar coincidencias.
     * @param p_gestorParque El gestor principal del parque.
     */
    private static void buscarPorNombreOpcion(GestorParque<Dinosaurio> p_gestorParque) {
        System.out.print("\nIntroduzca el nombre del dinosaurio a buscar:");
        String strNombre = sc.nextLine();

        try {
            Dinosaurio dinosaurioEncontrado = p_gestorParque.buscarPorNombre(strNombre);
            dinosaurioEncontrado.mostrarInformacion();

        } catch (IllegalArgumentException | IllegalStateException | DinosaurioNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Opción interactiva para crear una nueva actividad.
     * Solicita al usuario los datos para crear una nueva actividad y el gestor se encarga de añadirla a la lista general de actividades.
     * Gestiona una excepción en caso de que los datos dados por el usuario sean incorrectos.
     * @param lstActividades La lista general en la que se añadirá la nueva actividad.
     */
    private static void crearActividadOpcion(ArrayList<Actividad> lstActividades) {
        System.out.print("Introduzca el nombre de la actividad: ");
        String strNombreActividad = sc.nextLine();
        TipoDieta tipoDieta = leerTipoDieta();

        try {
            Actividad actividadCreada = new Actividad(strNombreActividad, tipoDieta);
            System.out.println("Actividad creada correctamente.");
            lstActividades.add(actividadCreada);
            System.out.println(actividadCreada);
        } catch (DatosInvalidosException die) {
            System.out.println(die.getMessage());
        }

    }

    /**
     * Opción para asignar una actividad a un dinosaurio.
     * Mediante el método para buscar un usuario por su nombre, el usuario introduce el nombre del
     * dinosaurio a buscar. Si existe, elegimos la actividad de las ya creadas y si son compatibles el
     * gestor se encarga de asignar la actividad al dinosaurio.
     * @param p_gestorParque El gestor principal del parque.
     * @param lstActividades La lista general de actividades.
     */
    private static void asignarActividadOpcion(GestorParque<Dinosaurio> p_gestorParque, ArrayList<Actividad> lstActividades) {
        if (p_gestorParque.getAll().isEmpty()) {
            System.out.println("Lista de dinosaurios vacía");
            return;
        } else if (lstActividades.isEmpty()) {
            System.out.println("Lista de actividades vacía");
            return;
        }

        System.out.print("Introduzca el nombre del dinosaurio a asignar: ");
        String strNombre = sc.nextLine();
        Dinosaurio dinosaurioElegido;
        try {
            dinosaurioElegido = p_gestorParque.buscarPorNombre(strNombre);
        } catch (DinosaurioNoEncontradoException | IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Lista de Actividades: ");
        for (int i = 0; i < lstActividades.size(); i++) {
            System.out.println(i + ": " + lstActividades.get(i).toString());
        }

        int iIndexLstActividades = leerInt("Elija una actividad de la lista (0, 1, 2 ...) : ");
        Actividad actividadElegida = null;
        if (!comprobarIndice(iIndexLstActividades, lstActividades)) {
            return;
        }

        actividadElegida = lstActividades.get(iIndexLstActividades);

        try {
            p_gestorParque.asignarActividad(dinosaurioElegido, actividadElegida);
        } catch (ActividadInvalidaException | IllegalStateException e ) {
            System.out.println(e.getMessage());
        }
    }

    // Métodos Auxiliares

    /**
     * Método auxiliar para leer un número entero por consola.
     * Atrapa excepciones de tipo InputMismatchException si el usuario introduce datos que no se ajustan a lo pedido.
     * @param strMensaje El texto que se mostrará al usuario antes de pedir el dato.
     * @return El número entero validado introducido por el usuario.
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
     * Método auxiliar para leer un número decimal por consola.
     * Atrapa excepciones de tipo InputMismatchException si el usuario introduce datos que no se ajustan a lo pedido.
     * @param strMensaje El texto que se mostrará al usuario antes de pedir el dato.
     * @return El número decimal validado introducido por el usuario.
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
     * Método auxiliar que despliega un submenú interactivo para que el usuario
     * seleccione un periodo.
     * @return El objeto de tipo Enum {@code Periodo} seleccionado.
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
            iOpcion = leerInt("Elija una opción: ");

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
                    System.out.println("\nOpción inválida.");
                    break;
            }
        } while (!bSalir);

        return ePeriodoSeleccionado;
    }

    /**
     * Método auxiliar que despliega un submenú interactivo para que el usuario
     * seleccione un tipo de dieta.
     * @return El objeto de tipo Enum {@code TipoDieta} seleccionado.
     */
    private static TipoDieta leerTipoDieta() {
        boolean bSalir = false;
        int iOpcion;
        TipoDieta eTipoDietaSeleccionado = null;
        do {
            System.out.println("Seleccione el tipo de dieta:");
            System.out.println("1. Carnivoro");
            System.out.println("2. Herbivoro");
            iOpcion = leerInt("Elija una opción: ");

            switch (iOpcion) {
                case 1:
                    eTipoDietaSeleccionado = TipoDieta.CARNIVORO;
                    bSalir = true;
                    break;
                case 2:
                    eTipoDietaSeleccionado = TipoDieta.HERBIVORO;
                    bSalir = true;
                    break;
                default:
                    System.out.println("\nOpción inválida.");
                    break;
            }
        } while (!bSalir);

        return eTipoDietaSeleccionado;
    }

    /**
     * Método auxiliar que comprueba si un índice dado está dentro de los límites válidos de
     * una lista dinámica.
     * @param <T> El tipo de objeto que se almacena en la lista.
     * @param iIndex El índice que vamos a evaluar.
     * @param lstResultados La lista en la que se validarán los límites.
     * @return {@code true} si el índice es correcto, {@code false} si el índice es incorrecto.
     */
    private static <T> boolean comprobarIndice(int iIndex, ArrayList<T> lstResultados) {
        boolean bRes = true;
        if (iIndex < 0 || iIndex >= lstResultados.size()) {
            System.out.println("Índice inválido");
            bRes = false;
        }

        return bRes;
    }
}
