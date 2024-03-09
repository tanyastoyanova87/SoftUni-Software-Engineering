package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P03PaintingEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sizeEggs = scanner.nextLine();
        String colorEggs = scanner.nextLine();
        int batches = Integer.parseInt(scanner.nextLine());

        if (sizeEggs.equals("Large")){
            if (colorEggs.equals("Red")){
                batches = batches * 16;
            } else if (colorEggs.equals("Green")) {
                batches = batches * 12;
            } else if (colorEggs.equals("Yellow")) {
                batches = batches * 9;
            }

        } else if (sizeEggs.equals("Medium")) {
            if (colorEggs.equals("Red")){
                batches = batches * 13;
            } else if (colorEggs.equals("Green")) {
                batches = batches * 9;
            } else if (colorEggs.equals("Yellow")) {
                batches = batches * 7;
            }

        } else if (sizeEggs.equals("Small")) {
            if (colorEggs.equals("Red")){
                batches = batches * 9;
            } else if (colorEggs.equals("Green")) {
                batches = batches * 8;
            } else if (colorEggs.equals("Yellow")) {
                batches = batches * 5;
            }

        }
        double expenses = 0.35 * batches;
        double total = batches - expenses;
        System.out.printf("%.2f leva.%n", total);
    }
}
