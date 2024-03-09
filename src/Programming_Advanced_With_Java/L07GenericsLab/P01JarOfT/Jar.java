package Programming_Advanced_With_Java.L07GenericsLab.P01JarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<E> {
    private Deque<E> deque;

    public Jar() {
        this.deque = new ArrayDeque<>();
    }

    public void add(E element) {
        this.deque.push(element);
    }

     public E remove() {
        return this.deque.pop();
     }
}
