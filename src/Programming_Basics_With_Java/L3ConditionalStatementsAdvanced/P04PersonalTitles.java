package Programming_Basics_With_Java.L3ConditionalStatementsAdvanced;

import java.util.Scanner;

public class P04PersonalTitles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double age = Double.parseDouble(scanner.nextLine());
        String gender = scanner.nextLine();

        if ("f".equals(gender)){
            if (age >= 16){
                System.out.println("Ms.");
            } else if (age < 16){
                System.out.println("Miss");
            }
        } else if ("m".equals(gender)){
            if (age >= 16){
                System.out.println("Mr.");
            } else if (age < 16){
                System.out.println("Master");
            }
        }
    }
}
