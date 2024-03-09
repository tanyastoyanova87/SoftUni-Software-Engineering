package Programming_Advanced_With_Java.L07GenericsLab.P04ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(ListUtils.getMin(numbers));

        List<String> strings = List.of("a", "b", "c");
        System.out.println(ListUtils.getMax(strings));
    }
}
