package Programming_Fundamentals_With_Java.L08TextProcessingLab;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String text = scanner.nextLine();

        //while (true) {
        while (text.contains(word)) {
            int index = text.indexOf(word);

            //if (index == -1) {
            //    break;
            //}

            String leftSubstring = text.substring(0, index);
            String rightSubstring = text.substring(index + word.length());

            text = leftSubstring + rightSubstring;
        }

        System.out.println(text);

        // while (text.contains(word)) {
        //
        //    text = text.replace(word, "");
        // }
        //
        // System.out.println(text);
    }
}
