import java.util.Currency;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        ApiRequest request = new ApiRequest();

        menu.Start();
        request.CurrencyRequest();
    }

}
