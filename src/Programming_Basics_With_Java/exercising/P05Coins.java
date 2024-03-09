package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P05Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());

        int coins = 0;
        double sum = Math.floor(change * 100);
        while (sum > 0){

            if (sum >= 200){
                sum -= 200;
                coins++;
            } else if (sum >= 100) {
                sum -= 100;
                coins++;
            }else if (sum >= 50) {
                sum -= 50;
                coins++;
            }else if (sum >= 20) {
                sum -= 20;
                coins++;
            }else if (sum >= 10) {
                sum -= 10;
                coins++;
            }else if (sum >= 5) {
                sum -= 5;
                coins++;
            }else if (sum >= 2) {
                sum -= 2;
                coins++;
            }else if (sum >= 1) {
                sum -= 1;
                coins++;
            }
        }
        System.out.println(coins);
    }
}
