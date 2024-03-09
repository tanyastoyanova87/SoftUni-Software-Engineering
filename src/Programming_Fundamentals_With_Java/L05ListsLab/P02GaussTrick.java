package Programming_Fundamentals_With_Java.L05ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        if (numbers.size() % 2 != 0) {
            int midInx = numbers.size() / 2;
            numbers.add(midInx, 0);
        }

        for (int i = 0; i < numbers.size() / 2; i++) {
            int leftElement = numbers.get(i);
            int rightElement = numbers.get(numbers.size() - i - 1);
            result.add(leftElement + rightElement);
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
