package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P06MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int maxNum = Integer.MIN_VALUE;
        while (!input.equals("Stop")){
            int num = Integer.parseInt(input);

            if (maxNum < num){
                maxNum = num;
            }
            input = scanner.nextLine();
        }
        System.out.println(maxNum);
    }
}
