package Retos.PruebaAutoria;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GestorEmbarque
{
    private Queue<IPasajero> m_filaGeneral;
    private Stack<Pasajero> m_problemasDocumentacion;
    private Vuelo m_vueloDestino;

    public GestorEmbarque() {
        this.m_filaGeneral = new LinkedList<>();
        this.m_problemasDocumentacion = new Stack<>();
        this.m_vueloDestino = new Vuelo("IB3000", 3);
    }

    public void agregarAFila(IPasajero p_Pasajero) { this.m_filaGeneral.offer(p_Pasajero); }

    public void procesarEmbarque() {

        int iIteraciones = this.m_filaGeneral.size();
        int iProcesados = 0;

        while (iProcesados < iIteraciones && !this.m_filaGeneral.isEmpty()) {

            IPasajero objPasajeroActual = this.m_filaGeneral.poll();
            iProcesados++;

            String strPasaporte = objPasajeroActual.getPasaporte();
            if (strPasaporte.charAt(0) == 'X') {
                this.m_problemasDocumentacion.push((Pasajero) objPasajeroActual);
                continue;
            }

            if (objPasajeroActual instanceof PasajeroVIP && !this.m_vueloDestino.estaLleno()) {
                PasajeroVIP objPasajeroVIP = (PasajeroVIP) objPasajeroActual;
                this.m_vueloDestino.offer(objPasajeroVIP);
                objPasajeroVIP.sumarMillar(500);
            } else {
                this.m_filaGeneral.offer(objPasajeroActual);
            }
        }
    }

    public Stack<Pasajero> getProblemasDocumentacion() { return m_problemasDocumentacion; }
    public Vuelo getVueloDestino() { return m_vueloDestino; }

}
