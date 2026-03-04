package Retos.GestionElectrodomesticos;

public class Electrodomestico {

    // Constantes
    protected static final double DEFAULT_PRECIO = 100;
    protected static final char DEFAULT_CONSUMO = 'F';
    protected static final String DEFAULT_COLOR = "Blanco";
    protected static final double DEFAULT_PESO = 5;

    // Propiedades
    protected double _dbPrecioBase;
    protected char _cConsumoEnergetico;
    protected String _strColor;
    protected double _dbPeso;

    // Métodos Get
    public double getPrecioBase() { return _dbPrecioBase; }
    public char getConsumoEnergetico() { return _cConsumoEnergetico; }
    public String getColor() { return _strColor; }
    public double getPeso() { return _dbPeso; }

    // Métodos Set
    private void setPrecioBase(double value) throws DatoInvalidoException {
        if (value <= 0) throw new DatoInvalidoException("El precio debe ser mayor que 0");
        this._dbPrecioBase = value;
    }

    private void setConsumoEnergetico(char value) {
        comprobarConsumoEnergetico(value);
    }

    private void setColor(String value) {
        comprobarColor(value);
    }

    private void setPeso(double value) throws DatoInvalidoException {
        if (value <= 0) throw new DatoInvalidoException("El peso debe ser mayor que 0");
        this._dbPeso = value;
    }

    // Constructor con todas las propiedades.
    public Electrodomestico(double p_dbPrecioBase, char p_cConsumoEnergetico, String p_strColor, double p_dbPeso) throws DatoInvalidoException {
        setPrecioBase(p_dbPrecioBase);
        setConsumoEnergetico(p_cConsumoEnergetico);
        setColor(p_strColor);
        setPeso(p_dbPeso);
    }

    // Constructor con el precio y peso, el resto por defecto.
    public Electrodomestico(double _dbPrecioBase, double _dbPeso) throws DatoInvalidoException {
        this(_dbPrecioBase, DEFAULT_CONSUMO, DEFAULT_COLOR, _dbPeso);
    }

    // Constructor por defecto.
    public Electrodomestico() throws DatoInvalidoException {
        this(DEFAULT_PRECIO, DEFAULT_CONSUMO, DEFAULT_COLOR, DEFAULT_PESO);
    }

    /**
     * Método para comprobar que la letra es correcta (A-F).
     * Si no es correcta, asignamos la letra por defecto.
     * @param cLetra Letra a comprobar.
     */
    private void comprobarConsumoEnergetico(char cLetra) {
        // Cada caracter lleva asignado un valor númerico siguiendo el codigo ASCII.
        if (cLetra >= 'A' && cLetra <= 'F') {
            this._cConsumoEnergetico = cLetra;
        } else {
            this._cConsumoEnergetico = DEFAULT_CONSUMO;
        }
    }

    /**
     * Método para comprobar que el color es correcto.
     * Si no es correcto, asignamos el color por defecto.
     * @param strColor Color a comprobar.
     */
    private void comprobarColor(String strColor) {
        String[] arrColores = {"Blanco", "Negro", "Rojo", "Azul", "Gris"};

        boolean bEncontrado = false;
        if (strColor != null) {
            for (String c : arrColores) {
                if (c.equalsIgnoreCase(strColor)) {
                    this._strColor = c;
                    bEncontrado = true;
                    break;
                }
            }
        }

        if (!bEncontrado) this._strColor = DEFAULT_COLOR;
    }

    /**
     * Método para calcular el precio final según el consumo y el tamaño.
     * @return Precio Final = Precio Base + Suplemento.
     */
    public double precioFinal() {
        double dbAumento = 0;

        switch (this._cConsumoEnergetico) {
            case 'A': dbAumento += 100; break;
            case 'B': dbAumento += 80;  break;
            case 'C': dbAumento += 60;  break;
            case 'D': dbAumento += 50;  break;
            case 'E': dbAumento += 30;  break;
            case 'F': dbAumento += 10;  break;
            default:  dbAumento += 0;   break;
        }

        // Cubrimos los decimales: si ponemos <= 19, no cubrimos los decimales.
        if (this._dbPeso >= 0 && this._dbPeso < 20) {
            dbAumento += 30;
        } else if (this._dbPeso >= 20 && this._dbPeso < 50) {
            dbAumento += 50;
        } else if (this._dbPeso >= 50 && this._dbPeso < 80) {
            dbAumento += 80;
        } else if (this._dbPeso >= 80) {
            dbAumento += 100;
        }

        return this._dbPrecioBase + dbAumento;
    }

}
