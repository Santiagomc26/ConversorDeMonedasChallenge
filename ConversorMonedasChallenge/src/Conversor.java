import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conversor {
    private static final String HISTORIAL_FILE = "historial.json";
    private final Metodo metodo;
    private final List<HistorialConversion> historial;
    private final Gson gson;

    public Conversor() {
        ObtensionDeDatos obtensionDeDatos = new ObtensionDeDatos();
        TasaDeCambio tasaDeCambio = obtensionDeDatos.buscaMonedas();
        this.metodo = new Metodo(tasaDeCambio);

        // Inicializar Gson con el adaptador para LocalDateTime
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

        this.historial = cargarHistorial();
    }

    public void realizarConversion(String monedaUno, String monedaDos, Scanner scanner) {
        System.out.print("Ingrese el monto en " + monedaUno + ": ");
        double cifra = scanner.nextDouble();

        try {
            double resultado = metodo.convertir(monedaUno, monedaDos, cifra);
            System.out.printf("Resultado: %.2f %s = %.2f %s%n", cifra, monedaUno, resultado, monedaDos);

            // Registrar en historial
            historial.add(new HistorialConversion(monedaUno, monedaDos, cifra, resultado, LocalDateTime.now()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
        } else {
            System.out.println("Historial de conversiones:");
            for (HistorialConversion registro : historial) {
                System.out.printf("%s: %.2f %s = %.2f %s%n", registro.getFecha(), registro.getMontoOrigen(),
                        registro.getMonedaOrigen(), registro.getMontoDestino(), registro.getMonedaDestino());
            }
        }
    }

    public void guardarHistorial() {
        try (FileWriter writer = new FileWriter(HISTORIAL_FILE)) {
            gson.toJson(historial, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el historial: " + e.getMessage());
        }
    }

    private List<HistorialConversion> cargarHistorial() {
        try (FileReader reader = new FileReader(HISTORIAL_FILE)) {
            Type listType = new TypeToken<ArrayList<HistorialConversion>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
