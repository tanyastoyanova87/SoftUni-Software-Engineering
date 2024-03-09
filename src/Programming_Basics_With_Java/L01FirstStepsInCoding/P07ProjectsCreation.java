package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P07ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int projects = Integer.parseInt(scanner.nextLine());
        int projectHours = projects * 3;
        System.out.println("The architect " + name + " will need " + projectHours + " hours to complete " + projects +
        " project/s.");
    }
}
