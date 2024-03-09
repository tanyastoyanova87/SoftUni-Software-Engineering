package Programming_Fundamentals_With_Java.L06ObjectsandClassesLab;

import java.util.*;
import java.util.stream.Collectors;

public class P01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> result = new ArrayList<>();

        Random random = new Random();

        int inputLength = input.size();
        for (int i = 0; i < inputLength; i++) {
            int index = random.nextInt(input.size());

            result.add(input.get(index));
            input.remove(index);

        }

        for (String word : result) {
            System.out.println(word);
        }
    }
}
