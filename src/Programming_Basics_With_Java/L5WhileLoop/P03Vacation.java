package Programming_Basics_With_Java.L5WhileLoop;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        int days = 0;
        int countSpend = 0;

        while (availableMoney < neededMoney){

            if (countSpend == 5){
                break;
            }

            String spendOrSave = scanner.nextLine();
            double currentMoney = Double.parseDouble(scanner.nextLine());
            days++;

            if (spendOrSave.equals("spend")){
                countSpend++;
                availableMoney = availableMoney - currentMoney;
            }else if (spendOrSave.equals("save")){
                availableMoney += currentMoney;
                countSpend = 0;
            }

            if (availableMoney < 0){
                availableMoney = 0;
            }
        }

        if (countSpend == 5){
            System.out.println("You can't save the money.");
            System.out.printf("%d%n", days);
        }else {
            System.out.printf("You saved the money for %d days.%n", days);
        }
    }
}
