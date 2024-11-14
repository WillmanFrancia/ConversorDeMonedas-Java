import com.sun.jdi.Value;

import java.util.Scanner;

public class Menu {

    public void Start() {
        Scanner userInput = new Scanner(System.in);

        String startMSG = """
                ********************************************
                WELCOME TO CURRENCY CHANGER!
                ********************************************
                PLEASE CHOOSE AN OPTION :
                
                1) USD to PEN
                """;
        System.out.println(startMSG);
        int userOption = Integer.valueOf(userInput.nextLine());



    }
}
