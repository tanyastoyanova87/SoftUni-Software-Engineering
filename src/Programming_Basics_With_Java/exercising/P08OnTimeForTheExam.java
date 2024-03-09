package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P08OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arrivingHour = Integer.parseInt(scanner.nextLine());
        int arrivingMinutes = Integer.parseInt(scanner.nextLine());

        int examTotalMinutes = examHour * 60 + examMinutes;
        int arrivingTotalMinutes = arrivingHour * 60 + arrivingMinutes;

        int diff = Math.abs(examTotalMinutes - arrivingTotalMinutes);

        if (arrivingTotalMinutes > examTotalMinutes){
            System.out.println("Late");
            if (diff < 60){
                System.out.printf("%d minutes after the start%n", diff);
            }else {
                int hour = diff / 60;
                int minutes = diff % 60;
                System.out.printf("%d:%02d hours after the start%n", hour, minutes);
            }
        } else if (diff <= 30) {
            System.out.println("On time");
            if (arrivingTotalMinutes != examTotalMinutes){
                System.out.printf("%d minutes before the start%n", diff);
            }
        }else {
            System.out.println("Early");
            if (diff < 60){
                System.out.printf("%d minutes before the start", diff);
            }else {
                int hour = diff / 60;
                int minutes = diff % 60;
                System.out.printf("%d:%02d hours before the start%n", hour, minutes);
            }
        }
    }
}
