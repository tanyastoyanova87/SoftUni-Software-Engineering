package Programming_Fundamentals_With_Java.L05ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> numbers2 = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        int index = 0;
        if (numbers.size() > numbers2.size()) {
            for (int i = 0; i < numbers2.size(); i++) {
                result.add(numbers.get(index));
                result.add(numbers2.get(index));
                index++;
            }
            for (int i = numbers2.size() + 1; i <= numbers.size(); i++) {
                result.add(numbers.get(index));
                index++;

            }
        } else {
            for (int i = 0; i < numbers.size(); i++) {
                result.add(numbers.get(index));
                result.add(numbers2.get(index));
                index++;
            }
            for (int i = numbers.size() + 1; i <= numbers2.size(); i++) {
                result.add(numbers2.get(index));
                index++;

            }
        }
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
