import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiRequest {

    String apiKey = "17425e3a73150df61188b316";
    // Setting URL
    String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

    Gson gson = new Gson();



    public void CurrencyRequest() {
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
            double usdRate = subProperty.get("PEN").getAsDouble();

            Moneda moneda = gson.fromJson(root, Moneda.class);
            System.out.println(moneda.conversion_rates().get("PEN"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}