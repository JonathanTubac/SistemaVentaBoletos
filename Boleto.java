/**
 * La clase Boleto representa un boleto vendido en el sistema de ventas.
 */
public class Boleto {
    private long noBoleto;
    private String comprador;
    private String localidad;
    private String fecha;

    /**
     * Constructor de la clase Boleto.
     * 
     * @param noBoleto  El número del boleto.
     * @param comprador El nombre del comprador.
     * @param localidad La localidad del boleto.
     * @param fecha     La fecha de compra del boleto.
     */
    public Boleto(long noBoleto, String comprador, String localidad, String fecha) {
        this.noBoleto = noBoleto;
        this.comprador = comprador;
        this.localidad = localidad;
        this.fecha = fecha;
    }

    /**
     * Obtiene el número del boleto.
     * 
     * @return El número del boleto.
     */
    public long getNoBoleto() {
        return noBoleto;
    }

    /**
     * Obtiene el nombre del comprador.
     * 
     * @return El nombre del comprador.
     */
    public String getComprador() {
        return comprador;
    }

    /**
     * Obtiene la localidad del boleto.
     * 
     * @return La localidad del boleto.
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Obtiene la fecha de compra del boleto.
     * 
     * @return La fecha de compra del boleto.
     */
    public String getFecha() {
        return fecha;
    }
}
