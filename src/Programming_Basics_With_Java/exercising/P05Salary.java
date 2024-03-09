package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P05Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int openedTabs = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= openedTabs ; i++) {
            String websiteName = scanner.nextLine();

            if (websiteName.equals("Facebook")){
                salary -= 150;
            } else if (websiteName.equals("Instagram")) {
                salary -= 100;
            } else if (websiteName.equals("Reddit")) {
                salary -= 50;
            }

            if (salary <= 0){
                System.out.println("You have lost your salary.");
                break;
            }
        }
        if (salary > 0){
            System.out.printf("%d%n", salary);
        }
    }
}
