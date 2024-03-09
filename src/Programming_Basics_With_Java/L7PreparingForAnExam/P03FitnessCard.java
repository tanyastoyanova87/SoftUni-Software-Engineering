package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P03FitnessCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = Double.parseDouble(scanner.nextLine());
        String fOrM = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String sport = scanner.nextLine();

        double cardPrice = 0;

        if (sport.equals("Gym")){
            if (fOrM.equals("m")){
                cardPrice = 42;
            } else if (fOrM.equals("f")) {
                cardPrice = 35;
            }

        }else if (sport.equals("Boxing")){
            if (fOrM.equals("m")){
                cardPrice = 41;
            } else if (fOrM.equals("f")) {
                cardPrice = 37;
            }

        } else if (sport.equals("Yoga")) {
            if (fOrM.equals("m")){
                cardPrice = 45;
            } else if (fOrM.equals("f")) {
                cardPrice = 42;
            }

        } else if (sport.equals("Zumba")) {
            if (fOrM.equals("m")){
                cardPrice = 34;
            } else if (fOrM.equals("f")) {
                cardPrice = 31;
            }

        } else if (sport.equals("Dances")) {
            if (fOrM.equals("m")){
                cardPrice = 51;
            }else if (fOrM.equals("f")){
                cardPrice = 53;
            }

        } else if (sport.equals("Pilates")) {
            if (fOrM.equals("m")){
                cardPrice = 39;
            } else if (fOrM.equals("f")) {
                cardPrice = 37;
            }

        }
        if (age <= 19){
            cardPrice = cardPrice - cardPrice * 0.20;
        }

        if (sum >= cardPrice){
            System.out.printf("You purchased a 1 month pass for %s.%n", sport);
        }else {
            double needed = Math.abs(sum - cardPrice);
            System.out.printf("You don't have enough money! You need $%.2f more.%n", needed );
        }
    }
}
