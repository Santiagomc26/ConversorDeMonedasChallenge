public class Metodo {
    private final Moneda conversionTasa;

    public Metodo(TasaDeCambio tasaDeCambio) {
        this.conversionTasa = tasaDeCambio.conversionTasa();
    }

    public double convertir(String monedaUno, String monedaDos, double cifra) {
        double tasaUno = getRate(monedaUno);
        double tasaDos = getRate(monedaDos);

        return cifra / tasaUno * tasaDos;
    }

    private double getRate(String currencyCode) {
        return switch (currencyCode.toUpperCase()) {
            case "USD" -> conversionTasa.USD();
            case "ARS" -> conversionTasa.ARS();
            case "BRL" -> conversionTasa.BRL();
            case "CLP" -> conversionTasa.CLP();
            case "COP" -> conversionTasa.COP();
            case "BOB" -> conversionTasa.BOB();
            default -> throw new IllegalArgumentException("Moneda no soportada: " + currencyCode);
        };
    }
}
