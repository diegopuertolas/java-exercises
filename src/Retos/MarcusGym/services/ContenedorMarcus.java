package Retos.MarcusGym.services;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContenedorMarcus<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private List<T> gestorMarcus;

    public ContenedorMarcus() {
        this.gestorMarcus = new ArrayList<>();
    }


    public void agregarElemento(T elemento) {
        if (elemento == null) throw new IllegalArgumentException("El elemento no puede ser nulo");
        this.gestorMarcus.add(elemento);
    }

    public void eliminarElemento(T elemento) {
        if (elemento == null) throw new IllegalArgumentException("El elemento no puede ser nulo");
        this.gestorMarcus.remove(elemento);
    }

    public void listarElementos() {
        for (T elemento : gestorMarcus) {
            System.out.println(elemento);
        }
    }

}
