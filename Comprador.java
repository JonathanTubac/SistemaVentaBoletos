/**
 * La clase Comprador representa un comprador en el sistema de ventas.
 */
public class Comprador {
    private String nombre;
    private String email;
    private int cantBoletos;
    private double presupuesto;

    /**
     * Constructor de la clase Comprador.
     * 
     * @param nombre      El nombre del comprador.
     * @param email       El email del comprador.
     * @param cantBoletos La cantidad de boletos a comprar.
     * @param presupuesto El presupuesto máximo del comprador.
     */
    public Comprador(String nombre, String email, int cantBoletos, double presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.cantBoletos = cantBoletos;
        this.presupuesto = presupuesto;
    }

    /**
     * Obtiene el nombre del comprador.
     * 
     * @return El nombre del comprador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el email del comprador.
     * 
     * @return El email del comprador.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene la cantidad de boletos a comprar.
     * 
     * @return La cantidad de boletos.
     */
    public int getCantBoletos() {
        return cantBoletos;
    }

    /**
     * Obtiene el presupuesto máximo del comprador.
     * 
     * @return El presupuesto máximo.
     */
    public double getPresupuesto() {
        return presupuesto;
    }

    /**
     * Valida el presupuesto del comprador.
     * 
     * @param precioT El precio total de los boletos.
     * @return El precio total.
     */
    public double validarPresupuesto(double precioT) {
        return precioT;
    }
}
