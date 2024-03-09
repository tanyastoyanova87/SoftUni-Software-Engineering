package Programming_Basics_With_Java.L5WhileLoop;

import java.util.Scanner;

public class P01ReadText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.next();

        while (!text.equals("Stop")){
            System.out.println(text);
            text = scanner.next();
        }
    }
}
