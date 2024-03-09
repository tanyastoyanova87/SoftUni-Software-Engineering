package Programming_Basics_With_Java.L3ConditionalStatementsAdvanced;

import java.util.Scanner;

public class P02SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degree= Integer.parseInt(scanner.nextLine());
        String day = scanner.nextLine();

        String outfit = "";
        String shoes = "";

        if (degree >= 10 && degree <= 18){
            if (day.equals("Morning")){
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            }else if (day.equals("Afternoon")){
                outfit = "Shirt";
                shoes = "Moccasins";
            }else {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        }else if (degree > 18 && degree <= 24){
            if (day.equals("Morning")){
                outfit = "Shirt";
                shoes = "Moccasins";
            }else if (day.equals("Afternoon")){
                outfit = "T-Shirt";
                shoes = "Sandals";
            }else {
                outfit = "Shirt";
                shoes = "Moccasins";

            }

        }else {
            if (day.equals("Morning")){
               outfit = "T-Shirt";
               shoes = "Sandals";
            }else if (day.equals("Afternoon")){
                outfit = "Swim Suit";
                 shoes = "Barefoot";
            }else {
                 outfit = "Shirt";
                 shoes = "Moccasins";
            }
        }
        System.out.printf("It's %d degrees, get your %s and %s.", degree, outfit, shoes );

    }
}
