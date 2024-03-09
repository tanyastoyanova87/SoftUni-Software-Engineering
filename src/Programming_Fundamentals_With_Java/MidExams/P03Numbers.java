package Programming_Fundamentals_With_Java.MidExams;

import java.util.*;
import java.util.stream.Collectors;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.sort(numbers);
        Collections.reverse(numbers);
        int sum = 0;
        int numbersCount = 0;
        for (int num : numbers) {
            sum += num;
            numbersCount++;
        }

        double averageNum = sum * 1.0 / numbersCount;

        int topNumbers = 0;
        for (int num : numbers) {
            if (num > averageNum) {
                topNumbers++;
                if (topNumbers <= 5) {
                    System.out.print(num + " ");
                }
            }
        }
        if (topNumbers == 0) {
            System.out.println("No");
        }
    }
}
