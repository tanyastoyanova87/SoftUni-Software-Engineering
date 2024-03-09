package Programming_Fundamentals_With_Java.L08TextProcessingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(" ");
        List<String> result = new ArrayList<>();

        for (String word : strings) {
            for (int i = 0; i < word.length(); i++) {
                result.add(word);
            }
        }

        System.out.println(String.join("", result));
    }
}
