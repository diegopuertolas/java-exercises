package Retos.MarcusGym.services;

import Retos.MarcusGym.models.Persona;

import java.io.*;

public class GestorFicheros {

    /**
     * Escribe un objeto ContenedorMarcus en un fichero binario.
     */
    public static void guardarDatos(ContenedorMarcus<Persona> datos, String rutaFichero) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero))) {
            oos.writeObject(datos);
        }
    }

    /**
     * Lee un fichero binario y lo convierte de vuelta a un objeto ContenedorMarcus.
     */
    @SuppressWarnings("unchecked")
    public static ContenedorMarcus<Persona> cargarDatos(String rutaFichero) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero))) {
            return (ContenedorMarcus<Persona>) ois.readObject();
        }
    }
}
