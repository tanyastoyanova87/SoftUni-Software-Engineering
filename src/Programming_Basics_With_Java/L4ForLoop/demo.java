package Programming_Basics_With_Java.L4ForLoop;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int num = Integer.parseInt(scanner.nextLine());

        while (num != 0){
            System.out.println(num);

            num = Integer.parseInt(scanner.nextLine());
        }
    }
}
