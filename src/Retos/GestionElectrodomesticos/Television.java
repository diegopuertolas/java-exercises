package Retos.GestionElectrodomesticos;

public class Television extends Electrodomestico {

    // Constantes
    private final static int DEFAULT_PULGADAS = 20;
    private final static boolean DEFAULT_SINTONIZADOR = false;

    // Propiedades
    private int _iPulgadas;
    private boolean _bTDT;

    // Métodos Get
    public int getPulgadas() { return _iPulgadas; }
    public boolean isTDT() { return _bTDT; }

    // Métodos Set
    private void setPulgadas(int value) throws DatoInvalidoException {
        if (value <= 0) throw new DatoInvalidoException("El número de pulgadas debe ser mayor que 0");
        this._iPulgadas = value;
    }

    private void setTDT(boolean value) {
        this._bTDT = value;
    }

    // Constructor con la resolución y el sintonizador TDT y el resto de atributos heredados
    public Television(double p_dbPrecioBase, char p_cConsumoEnergetico, String p_strColor, double p_dbPeso, int p_iPulgadas, boolean p_bTDT) throws DatoInvalidoException {
        super(p_dbPrecioBase, p_cConsumoEnergetico, p_strColor, p_dbPeso);
        setPulgadas(p_iPulgadas);
        setTDT(p_bTDT);
    }

    // Constructor con el precio y peso, el resto por defecto.
    public Television(double p_dbPrecioBase, double p_dbPeso) throws DatoInvalidoException {
        super(p_dbPrecioBase, DEFAULT_CONSUMO, DEFAULT_COLOR, p_dbPeso);
        setPulgadas(DEFAULT_PULGADAS);
        setTDT(DEFAULT_SINTONIZADOR);
    }

    // Constructor por defecto.
    public Television() throws DatoInvalidoException {
        this(DEFAULT_PRECIO, DEFAULT_CONSUMO, DEFAULT_COLOR, DEFAULT_PESO , DEFAULT_PULGADAS, DEFAULT_SINTONIZADOR);
    }

    /**
     * Método para calcula el precio final según la resolución y si tiene un sintonizador TDT incorporado.
     * @return Precio Final = Precio Final Electrodomestico + Posible aumento.
     */
    @Override
    public double precioFinal() {
        double dbPrecioElectrodomestico = super.precioFinal();
        double dbAumento = 0;
        if (this._iPulgadas > 40) {
            dbAumento += dbPrecioElectrodomestico * 0.3;
        }
        if(this._bTDT) {
            dbAumento += 50;
        }
        return dbPrecioElectrodomestico + dbAumento;
    }
}
