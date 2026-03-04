package Retos.MarcusGym;

import Ejercicios.Colecciones.DMSv2.exceptions.DatosInvalidosException;
import Retos.MarcusGym.enums.Especialidad;
import Retos.MarcusGym.enums.TipoMembresia;
import Retos.MarcusGym.models.Entrenador;
import Retos.MarcusGym.models.Persona;
import Retos.MarcusGym.models.Socio;
import Retos.MarcusGym.services.ContenedorMarcus;
import Retos.MarcusGym.services.GestorFicheros;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            List<Persona> lstPersonas = new ArrayList<>();

            Entrenador entrenador1 = new Entrenador("73441850K", "Diego", "Puértolas", 20, Especialidad.MUSCULACION, 2000);
            Entrenador entrenador2 = new Entrenador("17272632H", "David", "Canelita", 55, Especialidad.CROSSFIT, 3500);
            Socio socio1 = new Socio("1928282S", "Rocky", "Balboa", 30, TipoMembresia.VIP, 95);

            lstPersonas.add(entrenador1);
            lstPersonas.add(entrenador2);
            matricularSocio(lstPersonas, socio1);

            for (Persona persona : lstPersonas) {
                System.out.println(persona.mostrarRutina());
            }

            darDeBajaSocio(lstPersonas, socio1);
            for (Persona persona : lstPersonas) {
                System.out.println(persona);
            }

            Set<Socio> clubElite = new HashSet<>();

            clubElite.add(new Socio("12345678E", "Arnold", "Schwarzenegger", 40, TipoMembresia.BASICA, 105));
            clubElite.add(new Socio("12345678E", "Arnold Falso", "Schwarzenegger", 40, TipoMembresia.BASICA, 105));

            for (Socio socio: clubElite) {
                System.out.println(socio);
            }

            Map<Integer, Socio> asignacionTaquillas = new HashMap<>();

            Socio socio2 = new Socio("12345678E", "Arnold", "Schwarzenegger", 40, TipoMembresia.BASICA, 105);
            Socio socio3 = new Socio("28228822E", "Pepito", "Grillo", 90, TipoMembresia.BASICA, 32.1);

            asignacionTaquillas.put(1, socio2);
            asignacionTaquillas.put(2, socio3);

            asignarTaquilla(asignacionTaquillas, 1, socio1);
            asignarTaquilla(asignacionTaquillas, 3, socio1);

            ContenedorMarcus<Socio> cntPersona = new ContenedorMarcus<>();
            ContenedorMarcus<String> cntString = new ContenedorMarcus<>();

            cntString.agregarElemento("Mancuernas de 20kg");
            cntString.agregarElemento("Cinta de correr");
            System.out.println("Inventario material:");
            cntString.listarElementos();

            cntString.eliminarElemento("Cinta de correr");
            cntPersona.agregarElemento(new Socio("74382838P", "Pepito", "Grillo", 50, TipoMembresia.VIP, 130));

            cntPersona.listarElementos();

        } catch (DatosInvalidosException die) {
            System.out.println(die.getMessage());
        }

        final String RUTA_DATOS = "marcus_data.dat";

        try {
            System.out.println("=== NIVEL 4: EL PACTO DE DATOS (SERIALIZACIÓN) ===");

            ContenedorMarcus<Persona> gimnasioOriginal = new ContenedorMarcus<>();

            Entrenador entrenador = new Entrenador("73441850K", "Diego", "Puértolas", 20, Especialidad.MUSCULACION, 2000);
            Socio socio1 = new Socio("11111111A", "Rocky", "Balboa", 30, TipoMembresia.VIP, 95);
            Socio socio2 = new Socio("12345678E", "Arnold", "Schwarzenegger", 40, TipoMembresia.BASICA, 105);

            gimnasioOriginal.agregarElemento(entrenador);
            gimnasioOriginal.agregarElemento(socio1);
            gimnasioOriginal.agregarElemento(socio2);

            System.out.println("Guardando los datos en el disco duro...");
            GestorFicheros.guardarDatos(gimnasioOriginal, RUTA_DATOS);
            System.out.println("✅ Datos guardados con éxito.");


            // --- SIMULAMOS EL APAGÓN ---
            System.out.println("\n¡SE HA IDO LA LUZ EN EL BARRIO! ⚡");
            System.out.println("Reiniciando el sistema...\n");

            gimnasioOriginal = null;


            System.out.println("📂 Cargando los datos desde el archivo de recuperación...");
            ContenedorMarcus<Persona> gimnasioRecuperado = GestorFicheros.cargarDatos(RUTA_DATOS);

            System.out.println("✅ ¡Datos recuperados con éxito! Los supervivientes son:");
            gimnasioRecuperado.listarElementos(); 

        } catch (DatosInvalidosException die) {
            System.out.println("❌ Error en los datos: " + die.getMessage());
        } catch (IOException e) {
            System.out.println("❌ Error grave de Ficheros: No se pudo leer o escribir el archivo.");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error grave: El archivo leído no coincide con la estructura del programa.");
        }
    }

    public static void matricularSocio(List<Persona> lstPersonas, Socio socio) {
        if (!lstPersonas.contains(socio)) {
            lstPersonas.add(socio);
        }
    }

    public static void darDeBajaSocio(List<Persona> lstPersonas, Socio socio) {
        lstPersonas.remove(socio);
    }

    public static void asignarTaquilla(Map<Integer, Socio> mapTaquillas, int iNum, Socio socioNuevo) {
        if (mapTaquillas.containsKey(iNum)) {
            Socio ocupante = mapTaquillas.get(iNum);
            System.out.println("Esta taquilla ya es de: " + ocupante.getNombre() + "!");
        } else {
            mapTaquillas.put(iNum, socioNuevo);
            System.out.println("¡Taquilla " + iNum + " asignada");
        }
    }
}