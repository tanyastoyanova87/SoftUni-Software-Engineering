package Programming_Fundamentals_With_Java.L02DataTypesandVariablesLab;

import java.util.Scanner;

public class P05ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String lastName = scanner.nextLine();
        String delimiter = scanner.nextLine();

        System.out.println(name + delimiter + lastName);
    }
}
