package Programming_Fundamentals_With_Java.L05ListsLab;

import java.util.*;
import java.util.stream.Collectors;

public class P07RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                nums.add(numbers[i]);
            }
        }
        if (nums.size() == 0) {
            System.out.println("empty");
        } else {
            Collections.reverse(nums);
            for (int number : nums) {
                System.out.printf("%d ", number);
            }
        }
    }
}
