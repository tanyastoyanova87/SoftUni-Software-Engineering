package Programming_Advanced_With_Java.L07GenericsLab.P04ListUtilities;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> arr) {
        if (arr.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return arr.stream().min(Comparable::compareTo).get();
    }

    public static <T extends Comparable<T>> T getMax(List<T> arr) {
        if (arr.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return arr.stream().max(Comparable::compareTo).get();
    }
}
