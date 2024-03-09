package Programming_Advanced_With_Java.L07GenericsExercises.P04GenericSwapMethodIntege;

public class Box<T> {
    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",this.data.getClass().getName(), this.data);
    }
}
