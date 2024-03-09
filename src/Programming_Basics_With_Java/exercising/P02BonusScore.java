package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P02BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingBonusPoints = Integer.parseInt(scanner.nextLine());

        double bonusPoints = 0;
        if (startingBonusPoints <= 100){
            bonusPoints = 5;
            
        } else if (startingBonusPoints > 100 && startingBonusPoints < 1000) {
            bonusPoints = 0.20 * startingBonusPoints;
            
        } else if (startingBonusPoints > 1000) {
            bonusPoints = 0.10 * startingBonusPoints;
        }
        if (startingBonusPoints % 2 == 0){
            bonusPoints++;
        } else if (startingBonusPoints % 5 == 0) {
            bonusPoints += 2;
        }
        System.out.println(bonusPoints);
        double allPoints = startingBonusPoints + bonusPoints;
        System.out.println(allPoints);
    }
}
