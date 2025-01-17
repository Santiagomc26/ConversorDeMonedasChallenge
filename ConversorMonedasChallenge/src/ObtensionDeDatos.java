import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObtensionDeDatos {

    public TasaDeCambio buscaMonedas() {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f6b0a5cd8cb5f6229aeac73e/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), TasaDeCambio.class);

        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener la tasa de cambio: " + e.getMessage());
        }
    }
}

