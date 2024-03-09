package Programming_Fundamentals_With_Java.L03ArraysLab;

import java.util.Scanner;

public class P04ReverseAnArrayOfStrings2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split(" ");

        int j = elements.length - 1;
        for (int i = 0; i < elements.length / 2; i++) {
            String left = elements[i];
            String right = elements[j];

            elements[i] = right;
            elements[j] = left;
            j -= 1;
        }
        System.out.println(String.join(" ", elements));
    }
}
