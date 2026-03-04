package Ejercicios.POO.TransporteEmpresa;

import java.util.Arrays;

public class Ruta {

    // Propiedades
    private String[] m_arrParadas;
    private int m_iIndiceParadaActual;
    private Empleado[] m_arrPasajeros;
    private int m_iContadorPasajeros;

    // Métodos Get
    public String[] getParadas() { return m_arrParadas; }
    public int getIndiceParadaActual() { return m_iIndiceParadaActual; }
    public Empleado[] getPasajeros() { return m_arrPasajeros; }
    public int getContadorPasajeros() { return m_iContadorPasajeros; }


    // Métodos Set
    // Público para que el usuario pueda poner las paradas que quiera
    public void setParadas(String[] m_arrParadas) { this.m_arrParadas = m_arrParadas; }
    private void setIndiceParadaActual(int m_iIndiceParadaActual) { this.m_iIndiceParadaActual = m_iIndiceParadaActual; }
    private void setPasajeros(Empleado[] m_arrPasajeros) { this.m_arrPasajeros = m_arrPasajeros; }
    private void setContadorPasajeros(int m_iContadorPasajeros) { this.m_iContadorPasajeros = m_iContadorPasajeros; }


    // Constructor con parámetros
    public Ruta(int iCapacidadBus, int iNumParadas) {
        setPasajeros(new Empleado[iCapacidadBus]);
        setParadas(new String[iNumParadas]);
        setContadorPasajeros(0);
        setIndiceParadaActual(0);
    }

    /**
     * Método para que un empleado suba al autobús
     * @param empleado Clase Empleado
     */
    public void subirEmpleado(Empleado empleado) {
        if (this.m_iContadorPasajeros >= m_arrPasajeros.length) {
            System.out.println("Autobús lleno, no puede subirse.");
        } else if (empleado == null) {
            System.out.println("El empleado no puede ser null");
        } else {
            this.m_arrPasajeros[m_iContadorPasajeros] = empleado;
            this.m_iContadorPasajeros++;
        }
    }

    /**
     * Método para que un empleado baje del bus
     * @param empleado Clase Empleado
     */
    public void bajarEmpleado(Empleado empleado) {
        if (empleado == null) {
            System.out.println("El empleado no puede ser nulo.");
            return;
        }

        boolean bEncontrado = false;

        for (int i = 0; i < m_iContadorPasajeros && !bEncontrado; i++) {
            if (m_arrPasajeros[i].getNombre().equals(empleado.getNombre()) &&
                    m_arrPasajeros[i].getApellidos().equals(empleado.getApellidos()) &&
                    m_arrPasajeros[i].getEdad() == empleado.getEdad())
            {
                System.out.println(empleado + " se ha bajado del autobús.");

                // Calculamos la posición del último pasajero en el contador de pasajeros.
                int iUltimo = m_iContadorPasajeros - 1;

                // Copiamos al último pasajero en el hueco del que se va, si no es el mismo.
                if (i != iUltimo) {
                    m_arrPasajeros[i] = m_arrPasajeros[iUltimo];
                }

                // Borramos la referencia del último hueco.
                m_arrPasajeros[iUltimo] = null;

                // Reducimos el contador.
                m_iContadorPasajeros--;

                bEncontrado = true;
            }
        }
        if (!bEncontrado) {
            System.out.println("No está el empleado en el bus");
        }

    }

    /**
     * Método para obtener la parada actual del array de paradas.
     * @return String
     */
    public String obtenerParadaActual() {
        String strParadaActual;
        if (m_arrParadas != null && m_iIndiceParadaActual < m_arrParadas.length) {
            strParadaActual = this.m_arrParadas[m_iIndiceParadaActual];
        } else {
            strParadaActual = "Parada no definida";
        }
        return strParadaActual;
    }

    @Override
    public String toString() {
        return "Ruta [Paradas=" + Arrays.toString(m_arrParadas) +
                ", Pasajeros=" + m_iContadorPasajeros + "]";
    }
}
