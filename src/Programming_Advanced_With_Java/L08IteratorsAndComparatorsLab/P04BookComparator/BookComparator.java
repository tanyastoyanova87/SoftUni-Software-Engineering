package Programming_Advanced_With_Java.L08IteratorsAndComparatorsLab.P04BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.compareTo(o2);
    }
}