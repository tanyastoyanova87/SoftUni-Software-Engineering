package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        int daysSpend = 0;
        int daysSavedOrSaved = 0;
        boolean isFailed = false;
        while (availableMoney < neededMoney){

            if (daysSpend == 5){
                isFailed = true;
                break;
            }
            String spendOrSave = scanner.nextLine();
            double sum = Double.parseDouble(scanner.nextLine());
            daysSavedOrSaved++;

            if (spendOrSave.equals("save")){
                availableMoney += sum;
                daysSpend = 0;
            }else if (spendOrSave.equals("spend")){
                daysSpend++;
                availableMoney -= sum;
            }
            if (availableMoney <= 0){
                availableMoney = 0;
            }
        }
        if (isFailed){
            System.out.println("You can't save the money.");
            System.out.printf("%d%n", daysSavedOrSaved);
        }else {
            System.out.printf("You saved the money for %d days.%n", daysSavedOrSaved);
        }
    }
}
