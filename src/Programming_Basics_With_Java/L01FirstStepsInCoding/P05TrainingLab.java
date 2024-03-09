package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P05TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       double width = Double.parseDouble(scanner.nextLine());
       double height = Double.parseDouble(scanner.nextLine());

       double cmWidth = width * 100;
       double cmHeight = (height * 100) - 100;

       int deskPerRow = (int) (cmHeight / 70);
       int numberOfRows = (int) (cmWidth / 120);

       int seats = (deskPerRow * numberOfRows) - 3;
       System.out.println(seats);
    }
}
