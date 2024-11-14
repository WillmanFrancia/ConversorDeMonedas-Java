import java.util.Scanner;

public class Menu {


    public void Start() {
        Scanner userInput = new Scanner(System.in);
        String startMSG = """
                ********************************************
                        WELCOME TO CURRENCY CHANGER!
                ********************************************
                """;
        String menuTxt = """
                          PLEASE CHOOSE AN OPTION :
                
                1) Dollar => Sol
                2) Sol => Dollar
                3) Euro => Sol
                4) Sol => Euro
                5) Exit Program
                ********************************************
                """;
        String amountTxt = "Amount to change: ";
        String resultTxt = "Your change in ";
        ApiRequest request = new ApiRequest();
        Double changeValue = 0.0;
        String currencyType = "";
        String currencySign = "";
        String toChangeCurrency = "";
        outerLoop:

        while (true) {
            System.out.println(startMSG);
            System.out.println(menuTxt);
            System.out.println("Insert your choice number:");
            try {
                var userOption = Integer.valueOf(userInput.nextLine());

                switch (userOption) {
                    //Change to
                    case 1:
                        currencyType = "USD"; // Sol
                        toChangeCurrency = "PEN";
                        currencySign = "S/.";
                        break;
                    case 2:
                        currencyType = "PEN"; // Dollar
                        toChangeCurrency = "USD";
                        currencySign = "$";
                        break;
                    case 3:
                        currencyType = "EUR"; //Sol
                        toChangeCurrency = "PEN";
                        currencySign = "S/.";
                        break;
                    case 4:
                        currencyType = "PEN"; //Euro
                        toChangeCurrency = "EUR";
                        currencySign = "€";
                        break;
                    case 5:
                        System.out.println("Exit program...");
                        break outerLoop;
                    default:
                        System.out.println("Option not available");
                    continue;
                }
                changeValue = request.CurrencyRequest(currencyType, toChangeCurrency);
                System.out.println(amountTxt);
                var userAmount = Double.valueOf(userInput.nextLine());
                var change = userAmount * changeValue;
                System.out.println(resultTxt + " " + userAmount + currencyType + " " + " is: " + currencySign + change);
            }catch (NumberFormatException e){
                System.out.println("You may choose an option number");
            }
        }
    }
}

