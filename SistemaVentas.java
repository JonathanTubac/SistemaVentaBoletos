import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * La clase SistemaVentas gestiona la venta de boletos y las localidades.
 */
public class SistemaVentas {
    private ArrayList<Boleto> boletos;
    private ArrayList<Comprador> compradores;
    private Map<String, Localidad> localidades;
    private int correlativo;
    private int boletosVendidos;
    private Scanner scanner;

    /**
     * Constructor de la clase SistemaVentas.
     */
    public SistemaVentas() {
        boletos = new ArrayList<>();
        compradores = new ArrayList<>();
        localidades = new HashMap<>();
        correlativo = 1;
        boletosVendidos = 0;
        scanner = new Scanner(System.in);

        localidades.put("Balcon2", new Localidad("Balcon2", 100, 300));
        localidades.put("Platea", new Localidad("Platea", 100, 600));
        localidades.put("Balcon1", new Localidad("Balcon1", 100, 1800));
    }

    /**
     * Realiza la compra de boletos por un comprador.
     */
    public void comprarBoleto() {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese la cantidad de boletos a comprar (máximo 6): ");
        int cantidad = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese su presupuesto máximo: ");
        double presupuesto = Double.parseDouble(scanner.nextLine());

        if (cantidad > 6) {
            System.out.println("No puede comprar más de 6 boletos.");
            return;
        }

        Comprador comprador = new Comprador(nombre, email, cantidad, presupuesto);

        System.out.println("Seleccione la localidad:");
        System.out.println("1. Balcon2");
        System.out.println("2. Platea");
        System.out.println("3. Balcon1");
        int opcion = Integer.parseInt(scanner.nextLine());

        String localidadSeleccionada = "";
        switch (opcion) {
            case 1:
                localidadSeleccionada = "Balcon2";
                break;
            case 2:
                localidadSeleccionada = "Platea";
                break;
            case 3:
                localidadSeleccionada = "Balcon1";
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        Localidad localidad = localidades.get(localidadSeleccionada);

        if (localidad.getCapacidadDisp() < cantidad) {
            System.out.println("No hay suficientes boletos disponibles en " + localidadSeleccionada);
            return;
        }
        if (comprador.validarPresupuesto(localidad.getPrecio() * cantidad) > presupuesto) {
            System.out.println("El presupuesto es insuficiente para comprar los boletos.");
            return;
        }

        localidad.reducirDisp(cantidad);
        boletosVendidos += cantidad;

        String fechaVenta = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("ddMMyyyy"));
        for (int i = 0; i < cantidad; i++) {
            long noBoleto = generarNoBoleto(fechaVenta);
            Boleto boleto = new Boleto(noBoleto, nombre, localidadSeleccionada, fechaVenta);
            boletos.add(boleto);
        }

        compradores.add(comprador);
        System.out.println("Compra realizada con éxito. Boletos generados:");
        imprimirBoletosDeComprador(comprador);
    }

    /**
     * Genera un número de boleto único.
     * 
     * @param fecha La fecha de compra del boleto.
     * @return El número de boleto generado.
     */
    private long generarNoBoleto(String fecha) {
        return Long.parseLong(fecha + String.format("%04d", correlativo++));
    }

    /**
     * Consulta la disponibilidad total de boletos en todas las localidades.
     */
    public void consultarDispT() {
        localidades.forEach((nombre, localidad) -> {
            System.out.println(nombre + ": " + localidad.getCapacidadDisp() + " boletos disponibles.");
        });
    }

    /**
     * Consulta la disponibilidad de boletos en una localidad específica.
     */
    public void consultarDispL() {
        System.out.println("Seleccione la localidad:");
        System.out.println("1. Balcon2");
        System.out.println("2. Platea");
        System.out.println("3. Balcon1");
        int opcion = Integer.parseInt(scanner.nextLine());

        String localidadSeleccionada = "";
        switch (opcion) {
            case 1:
                localidadSeleccionada = "Balcon2";
                break;
            case 2:
                localidadSeleccionada = "Platea";
                break;
            case 3:
                localidadSeleccionada = "Balcon1";
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        Localidad localidad = localidades.get(localidadSeleccionada);
        System.out.println(localidadSeleccionada + ": " + localidad.getCapacidadDisp() + " boletos disponibles.");
    }

    /**
     * Genera un reporte de caja mostrando el total de dinero generado.
     */
    public void reporteCaja() {
        double totalRecaudado = boletos.stream()
                .mapToDouble(boleto -> localidades.get(boleto.getLocalidad()).getPrecio()).sum();
        System.out.println("Total recaudado: Q" + totalRecaudado);
    }

    /**
     * Imprime los compradores con sus respectivos boletos.
     */
    public void imprimirCompradoresConBoletos() {
        for (Comprador comprador : compradores) {
            System.out.println("Comprador: " + comprador.getNombre());
            imprimirBoletosDeComprador(comprador);
        }
    }

    /**
     * Imprime los boletos de un comprador específico.
     * 
     * @param comprador El comprador cuyos boletos se van a imprimir.
     */
    private void imprimirBoletosDeComprador(Comprador comprador) {
        boletos.stream()
                .filter(boleto -> boleto.getComprador().equals(comprador.getNombre()))
                .forEach(boleto -> {
                    System.out.println("Boleto No: " + boleto.getNoBoleto() + ", Localidad: " + boleto.getLocalidad()
                            + ", Fecha: " + boleto.getFecha());
                });
    }

    /**
     * Sale del sistema de ventas.
     * 
     * @return true para indicar que el usuario desea salir.
     */
    public boolean salir() {
        System.out.println("Gracias por utilizar el sistema de ventas. ¡Hasta luego!");
        return true;
    }
}
