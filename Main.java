import java.util.Scanner;

/**
 * La clase `Main` ejecuta el programa del sistema de ventas de boletos.
 * 
 * Esta clase contiene el método `main` que proporciona un menú interactivo para que el usuario
 * pueda realizar operaciones como comprar boletos, consultar disponibilidad, generar reportes,
 * e imprimir la lista de compradores con boletos.
 */
public class Main {
    
    /**
     * Método principal que inicia el menú del sistema de ventas de boletos.
     * 
     * El método `main` presenta un menú de opciones al usuario y permite realizar las siguientes
     * acciones:
     * <ul>
     *     <li>Comprar boletos</li>
     *     <li>Consultar disponibilidad total</li>
     *     <li>Consultar disponibilidad por localidad</li>
     *     <li>Generar un reporte de caja</li>
     *     <li>Imprimir la lista de compradores con boletos</li>
     *     <li>Salir del programa</li>
     * </ul>
     * El menú se ejecuta en un bucle hasta que el usuario decide salir.
     *
     * @param args Argumentos de línea de comandos (no utilizados en esta implementación).
     */
    public static void main(String[] args) {
        SistemaVentas sistema = new SistemaVentas();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("");
            System.out.println("Menú del Sistema de Ventas:");
            System.out.println("1. Comprar boleto");
            System.out.println("2. Consultar disponibilidad total");
            System.out.println("3. Consultar disponibilidad por localidad");
            System.out.println("4. Reporte de caja");
            System.out.println("5. Imprimir compradores con boletos");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("");
                    sistema.comprarBoleto();
                    break;
                case 2:
                    System.out.println("");
                    sistema.consultarDispT();
                    break;
                case 3:
                    System.out.println("");
                    sistema.consultarDispL();
                    break;
                case 4:
                    System.out.println("");
                    sistema.reporteCaja();
                    break;
                case 5:
                    System.out.println("");
                    sistema.imprimirCompradoresConBoletos();
                    break;
                case 6:
                    System.out.println("");
                    salir = sistema.salir();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }

        scanner.close();
    }
}
