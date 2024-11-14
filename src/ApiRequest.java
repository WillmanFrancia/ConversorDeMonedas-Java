import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiRequest {
    String apiKey = "";
    public Double CurrencyRequest(String currency, String toChangeCurrency) {


        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + currency;

        Gson gson = new Gson();

        Double changeCurrency = 0.0;
        try {
            // Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            request.connect();
            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Accessing object
            JsonObject subProperty = jsonobj.getAsJsonObject("conversion_rates");
            double usdRate = subProperty.get(currency).getAsDouble();

            Moneda moneda = gson.fromJson(root, Moneda.class);
            changeCurrency = moneda.conversion_rates().get(toChangeCurrency);

        } catch (NumberFormatException | IOException e) {
            System.out.println("You must choose a number");
        }
        return changeCurrency;
    }
}