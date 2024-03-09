package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        System.out.println( "Hello, my name is " + name + " I am " +  age  + " years old and " + height + " cm" );
    }
}
