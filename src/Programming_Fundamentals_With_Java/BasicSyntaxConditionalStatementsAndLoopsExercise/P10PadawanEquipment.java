package Programming_Fundamentals_With_Java.BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyGeorgeHas = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double lightsabers = Math.ceil(studentsCount + studentsCount * 0.10) * lightsaberPrice;
        double robes = robePrice * studentsCount;
        double belts = (studentsCount - studentsCount / 6) * beltPrice;

        double total = lightsabers + robes + belts;

        if (moneyGeorgeHas >= total){
            System.out.printf("The money is enough - it would cost %.2flv.%n", total);
        }else {
            double neededMoney = total - moneyGeorgeHas;
            System.out.printf("George Lucas will need %.2flv more.%n", neededMoney);
        }
    }
}
