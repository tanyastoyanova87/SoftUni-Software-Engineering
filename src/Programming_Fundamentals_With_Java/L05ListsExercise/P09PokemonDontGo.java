package Programming_Fundamentals_With_Java.L05ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;
        while (numbers.size() > 0) {
            int currentIndex = Integer.parseInt(scanner.nextLine());

            if (currentIndex >= 0 && currentIndex <= numbers.size() - 1) {

                int removedElement = numbers.get(currentIndex);
                sum += removedElement;
                numbers.remove(currentIndex);
                modifyList(numbers, removedElement);

            } else if (currentIndex < 0) {
                int removedElement = numbers.get(0);
                int lastElement = numbers.get(numbers.size() - 1);
                sum += removedElement;

                numbers.remove(0);
                numbers.add(0, lastElement);
                modifyList(numbers, removedElement);

            } else if (currentIndex > numbers.size() - 1) {
                int removedElement = numbers.get(numbers.size() - 1);
                int firstElement = numbers.get(0);
                sum += removedElement;

                numbers.remove(numbers.size() - 1);
                numbers.add(firstElement);
                modifyList(numbers, removedElement);
            }
        }

        System.out.println(sum);
    }

    private static void modifyList(List<Integer> numbers, int removedElement) {

        for (int i = 0; i < numbers.size(); i++) {

            int currentElement = numbers.get(i);
            if (currentElement <= removedElement) {
                currentElement += removedElement;
            } else {
                currentElement -= removedElement;
            }
            numbers.set(i, currentElement);
        }
    }
}
