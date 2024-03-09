package Programming_Fundamentals_With_Java.L05ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> numbers = Arrays.stream(input.split("\\|")).collect(Collectors.toList());

        Collections.reverse(numbers);

        System.out.println(numbers.toString()
                .replace("[", "")
                .replace("]", "")
                .trim()
                .replaceAll(",", "")
                .replaceAll("\\s+", " "));
    }
}
