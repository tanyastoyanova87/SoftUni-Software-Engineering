package Programming_Fundamentals_With_Java.L03ArraysLab;

import java.util.Scanner;

public class P04ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split(" ");
        String[] reversed = new String[elements.length];

        int reversedInx = 0;
        for (int i = elements.length - 1; i >= 0; i--) {
            reversed[reversedInx] = elements[i];
            reversedInx += 1;
        }
        System.out.println(String.join(" ", reversed));
    }
}
