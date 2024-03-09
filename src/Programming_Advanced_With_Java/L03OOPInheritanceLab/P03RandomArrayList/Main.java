package Programming_Advanced_With_Java.L03OOPInheritanceLab.P03RandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Integer> numbers = new RandomArrayList();

        numbers.add(13);
        numbers.add(23);
        numbers.add(58);
        numbers.add(56);

        System.out.println(numbers.getRandomElement());
    }
}
