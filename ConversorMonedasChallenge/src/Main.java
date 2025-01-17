import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Conversor conversor = new Conversor();

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu(); // Mostrar menú en cada iteración.

            try {
                int opcion = scanner.nextInt(); // Capturar opción.
                switch (opcion) {
                    case 1 -> conversor.realizarConversion("USD", "ARS", scanner);
                    case 2 -> conversor.realizarConversion("ARS", "USD", scanner);
                    case 3 -> conversor.realizarConversion("USD", "BRL", scanner);
                    case 4 -> conversor.realizarConversion("BRL", "USD", scanner);
                    case 5 -> conversor.realizarConversion("BOB", "USD", scanner);
                    case 6 -> conversor.realizarConversion("USD", "BOB", scanner);
                    case 7 -> conversor.realizarConversion("CLP", "USD", scanner);
                    case 8 -> conversor.realizarConversion("USD", "CLP", scanner);
                    case 9 -> conversor.realizarConversion("USD", "COP", scanner);
                    case 10 -> conversor.realizarConversion("COP", "USD", scanner);
                    case 11 -> conversor.mostrarHistorial();
                    case 12 -> {
                        conversor.guardarHistorial();
                        salir = true;
                        System.out.println("¡Gracias por usar el conversor de monedas! ¡Hasta pronto!");
                    }
                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar el búfer del scanner.
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("**********************************************");
        System.out.println("**** Bienvenido/a al conversor de monedas ****");
        System.out.println("******************* MENU *********************");
        System.out.println("* 1.- Dólar (USD) a Peso Argentino (ARS)     *");
        System.out.println("* 2.- Peso Argentino (ARS) a Dólar (USD)     *");
        System.out.println("* 3.- Dólar (USD) a Real Brasileño (BRL)     *");
        System.out.println("* 4.- Real Brasileño (BRL) a Dólar (USD)     *");
        System.out.println("* 5.- Boliviano (BOB) a Dólar (USD)          *");
        System.out.println("* 6.- Dólar (USD) a Boliviano (BOB)          *");
        System.out.println("* 7.- Peso Chileno (CLP) a Dólar (USD)       *");
        System.out.println("* 8.- Dólar (USD) a Peso Chileno (CLP)       *");
        System.out.println("* 9.- Dólar (USD) a Peso Colombiano (COP)    *");
        System.out.println("* 10.- Peso Colombiano (COP) a Dólar (USD)   *");
        System.out.println("* 11.- Ver Historial                         *");
        System.out.println("* 12.- Salir                                 *");
        System.out.println("**********************************************");
        System.out.print("Seleccione una opción: ");
    }
}
