package Ejercicios.POO.RepasoPOO.Basicos.Ejercicio5;

public class Complejo {

    // Propiedades
    private double m_dbParteReal;
    private double m_dbParteImaginaria;

    // Métodos Get
    public double getParteReal() { return m_dbParteReal; }
    public double getParteImaginaria() { return m_dbParteImaginaria;}

    // Métodos Set
    private void setParteReal(double value) {
        this.m_dbParteReal = value;
    }
    private void setParteImaginaria(double value) {
        this.m_dbParteImaginaria = value;
    }

    // Constructor con parámetros
    public Complejo(double p_dbParteReal, double p_dbParteImaginaria) {
        setParteReal(p_dbParteReal);
        setParteImaginaria(p_dbParteImaginaria);
    }

    // Constructor por defecto
    public Complejo() {
        this(0, 0);
    }

    // Constructor copia
    public Complejo(Complejo otro) {
        validarObjeto(otro);
        setParteReal(otro.getParteReal());
        setParteImaginaria(otro.getParteImaginaria());
    }

    /**
     * Método para sumar números complejos.
     * @param otro Clase Complejo
     * @return Clase Complejo
     */
    public Complejo sumarComplejos(Complejo otro) {
        validarObjeto(otro);

        double dbNuevaParteReal = this.m_dbParteReal + otro.getParteReal();
        double dbNuevaParteImaginaria = this.m_dbParteImaginaria + otro.getParteImaginaria();

        return new Complejo(dbNuevaParteReal, dbNuevaParteImaginaria);
    }

    /**
     * Método para restar números complejos.
     * @param otro Clase Complejo
     * @return Clase Complejo
     */
    public Complejo restarComplejos(Complejo otro) {
        validarObjeto(otro);

        double dbNuevaParteReal = this.m_dbParteReal - otro.getParteReal();
        double dbNuevaParteImaginaria = this.m_dbParteImaginaria - otro.getParteImaginaria();

        return new Complejo(dbNuevaParteReal, dbNuevaParteImaginaria);
    }

    /**
     * Método para multiplicar números complejos.
     * @param otro Clase Complejo
     * @return Clase Complejo
     */
    public Complejo multiplicarComplejos(Complejo otro) {
        validarObjeto(otro);

        double dbNuevaParteReal = (this.m_dbParteReal * otro.getParteReal()) - (this.m_dbParteImaginaria * otro.getParteImaginaria());
        double dbNuevaParteImaginaria = (this.m_dbParteReal * otro.getParteImaginaria()) + (this.m_dbParteImaginaria * otro.getParteReal());

        return new Complejo(dbNuevaParteReal, dbNuevaParteImaginaria);
    }

    /**
     * Método para dividir números complejos.
     * @param otro Clase Complejo
     * @return Clase Complejo
     */
    public Complejo dividirComplejos(Complejo otro) {
        validarObjeto(otro);

        double dbDivisor = Math.pow(otro.getParteReal(), 2) + Math.pow(otro.m_dbParteImaginaria, 2);
        if (dbDivisor == 0) {
            throw new IllegalArgumentException("El denominador no puede ser 0");
        }

        double dbNuevaParteReal = ((this.m_dbParteReal * otro.getParteReal()) + (this.m_dbParteImaginaria * otro.getParteImaginaria())) / dbDivisor;
        double dbNuevaParteImaginaria = ((this.m_dbParteImaginaria * otro.getParteReal()) - (this.m_dbParteReal * otro.getParteImaginaria())) / dbDivisor;

        return new Complejo(dbNuevaParteReal, dbNuevaParteImaginaria);
    }

    /**
     * Método auxiliar para validar si un objeto es nulo.
     * @param obj Clase Object
     */
    private static void validarObjeto(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("El objeto no puede ser nulo");
        }
    }

    @Override
    public String toString() {
        if (m_dbParteImaginaria < 0) {
            return m_dbParteReal + " - " + Math.abs(m_dbParteImaginaria) + "i";
        }
        return m_dbParteReal + " + " + m_dbParteImaginaria + "i";
    }
}
