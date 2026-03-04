package Retos.GestionElectrodomesticos;

public class Lavadora extends Electrodomestico {

    // Constantes
    private static final double DEFAULT_CARGA = 5;

    // Propiedades
    protected double _dbCarga;

    // Métodos Get y Set
    public double getCarga() { return _dbCarga; }

    private void setCarga(double value) throws DatoInvalidoException {
        if (value <= 0) throw new DatoInvalidoException("La carga debe ser mayor que 0");
        this._dbCarga = value;
    }

    // Constructor con la carga y el resto de atributos heredados
    public Lavadora(double p_dbPrecioBase, char p_cConsumoEnergetico, String p_strColor, double p_dbPeso, double p_dbCarga) throws DatoInvalidoException {
        super(p_dbPrecioBase, p_cConsumoEnergetico, p_strColor, p_dbPeso);
        setCarga(p_dbCarga);
    }

    // Constructor con el precio y peso, el resto por defecto.
    public Lavadora(double p_dbPrecioBase, double p_dbPeso) throws DatoInvalidoException {
        super(p_dbPrecioBase, DEFAULT_CONSUMO, DEFAULT_COLOR, p_dbPeso);
        setCarga(DEFAULT_CARGA);
    }

    // Constructor por defecto.
    public Lavadora() throws DatoInvalidoException {
        this(DEFAULT_PRECIO, DEFAULT_CONSUMO, DEFAULT_COLOR, DEFAULT_PESO , DEFAULT_CARGA);
    }

    /**
     * Método para calcular el precio final según la carga.
     * Sobreescribimos el método de la Clase Electrodomestico.
     *
     * @return Precio Final = Precio Final Electrodomestico + Posible aumento por extra de carga.
     */
    @Override
    public double precioFinal() {
        double dbPrecioElectrodomestico = super.precioFinal();
        double dbAumento = 0;
        if(this._dbCarga > 30) {
            dbAumento += 50;
        }

        return dbPrecioElectrodomestico + dbAumento;
    }
}