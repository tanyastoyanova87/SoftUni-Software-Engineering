package Programming_Fundamentals_With_Java.L05ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] bombNumAndPower = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int bombNum = bombNumAndPower[0];
        int powerNum = bombNumAndPower[1];

        while (numbers.contains(bombNum)) {
            int bombIndex = numbers.indexOf(bombNum);

            int left = Math.max(0, bombIndex - powerNum);
            int right = Math.min(bombIndex + powerNum, numbers.size() - 1);

            for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }
        }
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println(sum);
    }
}
