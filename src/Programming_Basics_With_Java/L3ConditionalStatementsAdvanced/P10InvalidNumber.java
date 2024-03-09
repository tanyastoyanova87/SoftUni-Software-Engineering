package Programming_Basics_With_Java.L3ConditionalStatementsAdvanced;

import java.util.Scanner;

public class P10InvalidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        boolean valid = num >=100 && num <= 200 || num == 0;
        if (!valid){
            System.out.println("invalid");
        }else {

        }
    }
}
