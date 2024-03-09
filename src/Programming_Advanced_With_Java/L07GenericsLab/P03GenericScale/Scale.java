package Programming_Advanced_With_Java.L07GenericsLab.P03GenericScale;
public class Scale<T extends Comparable<T>> {
    private T left;

    private T right;
    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int result = this.left.compareTo(this.right);
        if (result == 0) {
            return null;
        }
        return result < 0 ? this.right : this.left;
    }
}
