package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P01ReadText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        while (!text.equals("Stop")){
            System.out.println(text);

            text = scanner.nextLine();
        }
    }
}
