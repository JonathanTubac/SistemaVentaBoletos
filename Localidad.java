/**
 * La clase Localidad representa una localidad donde se venden boletos.
 */
public class Localidad {
    private String nombre;
    private int capacidadTotal;
    private int capacidadDisponible;
    private double precio;

    /**
     * Constructor de la clase Localidad.
     * 
     * @param nombre        El nombre de la localidad.
     * @param capacidadTotal La capacidad total de la localidad.
     * @param precio        El precio del boleto en esta localidad.
     */
    public Localidad(String nombre, int capacidadTotal, double precio) {
        this.nombre = nombre;
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadTotal;
        this.precio = precio;
    }

    /**
     * Obtiene el nombre de la localidad.
     * 
     * @return El nombre de la localidad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la capacidad total de la localidad.
     * 
     * @return La capacidad total.
     */
    public int getCapacidadT() {
        return capacidadTotal;
    }

    /**
     * Obtiene la capacidad disponible de la localidad.
     * 
     * @return La capacidad disponible.
     */
    public int getCapacidadDisp() {
        return capacidadDisponible;
    }

    /**
     * Obtiene el precio del boleto en esta localidad.
     * 
     * @return El precio del boleto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Reduce la capacidad disponible de la localidad.
     * 
     * @param cantidad La cantidad de boletos a reducir.
     */
    public void reducirDisp(int cantidad) {
        capacidadDisponible -= cantidad;
    }
}
