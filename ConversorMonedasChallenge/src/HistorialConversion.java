import java.time.LocalDateTime;

public class HistorialConversion {
    private final String monedaOrigen;
    private final String monedaDestino;
    private final double montoOrigen;
    private final double montoDestino;
    private final LocalDateTime fecha;

    public HistorialConversion(String monedaOrigen, String monedaDestino, double montoOrigen, double montoDestino, LocalDateTime fecha) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.montoOrigen = montoOrigen;
        this.montoDestino = montoDestino;
        this.fecha = fecha;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getMontoOrigen() {
        return montoOrigen;
    }

    public double getMontoDestino() {
        return montoDestino;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
