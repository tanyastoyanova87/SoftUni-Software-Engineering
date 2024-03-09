package Programming_Fundamentals_With_Java.L04MethodsExercise;

import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();

        printVowels(text);
    }

    public static void printVowels(String text) {
        int vowels = 0;

        for (char symbols : text.toCharArray()) {
            if (symbols == 'a' || symbols == 'o' || symbols == 'e' || symbols == 'u' || symbols == 'i') {
                vowels++;
            }
        }
        System.out.println(vowels);
    }
}
