package Programming_Advanced_With_Java.L03SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" ")).map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1)).collect(Collectors.toList());

        if (numbers.size() < 3) {
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            return;
        }
        int firstBigNum = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > firstBigNum) {
                firstBigNum = num;
            }
        }
        System.out.print(firstBigNum + " ");
        numbers.remove(0);

        int secondBigNum = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > secondBigNum) {
                secondBigNum = num;
            }
        }
        System.out.print(secondBigNum + " ");
        numbers.remove(0);

        int thirdBigNum = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > thirdBigNum) {
                thirdBigNum = num;
            }
        }
        System.out.print(thirdBigNum + " ");
        numbers.remove(0);
    }
}
