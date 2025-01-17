import com.google.gson.annotations.SerializedName;

public record TasaDeCambio(
        @SerializedName("result") String result,
        @SerializedName("base_code") String baseCode,
        @SerializedName("conversion_rates") Moneda conversionTasa
) {
}



