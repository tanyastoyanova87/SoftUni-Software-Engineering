package Programming_Advanced_With_Java.L08IteratorsAndComparatorsLab.P02Library;

import Programming_Advanced_With_Java.L08IteratorsAndComparatorsLab.P01Book.Book;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }


    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    class LibIterator implements Iterator<Book> {

        private int pos = 0;

        @Override
        public boolean hasNext() {
            return pos < books.length;
        }

        @Override
        public Book next() {
            return books[pos++];
        }
    }
}
