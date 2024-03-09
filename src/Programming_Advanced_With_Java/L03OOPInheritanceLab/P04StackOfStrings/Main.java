package Programming_Advanced_With_Java.L03OOPInheritanceLab.P04StackOfStrings;

public class Main {
    public static void main(String[] args) {

        StackOfStrings stack = new StackOfStrings();

        stack.push("ball");
        stack.push("tennisRacket");
        stack.push("hat");

        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
