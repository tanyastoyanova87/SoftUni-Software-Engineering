package Programming_Basics_With_Java.PreExam;

import java.util.Scanner;

public class P05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int days = 1;
        int metresCount = 5364;
        while (!input.equals("END")){
            String yesOrNoOvernightStay = input;
            int metres = Integer.parseInt(scanner.nextLine());

            if (yesOrNoOvernightStay.equals("Yes")){
                days++;
            }

            if (days > 5){
                break;
            }
            metresCount += metres;

        if (metresCount >= 8848){
            System.out.printf("Goal reached for %d days!%n", days);
            break;

        }
            input = scanner.nextLine();

        }
        if (metresCount < 8848){
            System.out.println("Failed!");
            System.out.printf("%d%n", metresCount);

        }
    }
}
