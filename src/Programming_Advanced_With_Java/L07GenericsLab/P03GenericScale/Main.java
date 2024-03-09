package Programming_Advanced_With_Java.L07GenericsLab.P03GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> scale = new Scale<>(1, 2);
        System.out.println(scale.getHeavier());
    }
}
