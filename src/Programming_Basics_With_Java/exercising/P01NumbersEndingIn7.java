package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P01NumbersEndingIn7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 7; i <= 997 ; i++) {
            if (i % 10 == 7){
                System.out.println(i);
            }
        }
    }
}
