package Programming_Basics_With_Java.L5WhileLoop;

import java.util.Scanner;

public class P05Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());
        int coinsCount = 0;
        double changeSum = Math.floor(change * 100);

        while (changeSum > 0){

            if (changeSum >= 200){
                changeSum -= 200;
                coinsCount++;
            } else if (changeSum >= 100) {
                changeSum -= 100;
                coinsCount++;
            } else if (changeSum >= 50) {
                changeSum -= 50;
                coinsCount++;
            } else if (changeSum >= 20) {
                changeSum -= 20;
                coinsCount++;
            } else if (changeSum >= 10) {
                changeSum -= 10;
                coinsCount++;
            } else if (changeSum >= 5) {
                changeSum -= 5;
                coinsCount++;
            } else if (changeSum >= 2) {
                changeSum -= 2;
                coinsCount++;
            } else if (changeSum >= 1) {
                changeSum -= 1;
                coinsCount++;
            }
        }
        System.out.println(coinsCount);
    }
}
