package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P01ExcellentResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        if (num >= 5){
            System.out.println("Excellent!");
        }
    }
}
