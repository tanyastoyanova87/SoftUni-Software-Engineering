package Programming_Basics_With_Java.L4ForLoop;

import java.util.Scanner;

public class P05CharacterSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        for (int i = 0; i < text.length() ; i++) {
            System.out.println(text.charAt(i));
        }
    }
}
