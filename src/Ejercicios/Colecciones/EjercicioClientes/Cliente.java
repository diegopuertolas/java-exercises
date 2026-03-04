package Ejercicios.Colecciones.EjercicioClientes;

import java.util.ArrayList;

public class Cliente {

    // Propiedades
    private String m_strNombre;
    private String m_strEmail;
    private ArrayList<String> m_arrTelefonos = new ArrayList<>();

    // Métodos Get y Set
    public String getNombre() { return m_strNombre; }
    private void setNombre(String value) { this.m_strNombre = value; }

    public String getEmail() { return m_strEmail; }
    private void setEmail(String value) { this.m_strEmail = value; }

    /**
     * Obtiene un telefono de una posicion específica.
     * @param index Indice de la lista.
     * @return El telefono en esa posición o una cadena vacía si el índice no es válido.
     */
    public String getTelefono(int index) {
        String strResultado = "";
        if (index >= 0 && index < this.m_arrTelefonos.size()) {
            strResultado = this.m_arrTelefonos.get(index);
        }
        return strResultado;
    }
    private void setTelefono(ArrayList<String> value) { this.m_arrTelefonos = value; }

    // Constructor con parámetros
    public Cliente(String p_strNombre, String p_strEmail) {
        setNombre(p_strNombre);
        setEmail(p_strEmail);
    }

    /**
     * Método para añadir un telefono al ArrayList de telefonos.
     * @param strTelefono Telefono a añadir.
     */
    public void addTelefono(String strTelefono) {
        if (!this.m_arrTelefonos.contains(strTelefono)) {
            this.m_arrTelefonos.add(strTelefono);
        } else {
            System.out.println("El telefono ya existe");
        }
    }

    /**
     * Método para buscar un telefono que contenga una cadena concreta
     * @param strCadena Parte de número a buscar.
     * @return ArrayList de las coincidencias encontradas.
     */
    public ArrayList<String> buscarTelefono(String strCadena) {
        ArrayList<String> arrResultados = new ArrayList<>();
        for (String telefono : this.m_arrTelefonos) {
            if (telefono.contains(strCadena)) {
                arrResultados.add(telefono);
            }
        }
        return arrResultados;
    }

    @Override
    public String toString() {
        return "Cliente: " + m_strNombre + " | " + m_strEmail + " | " + m_arrTelefonos;
    }
}
