package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P04SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNum = Integer.parseInt(scanner.nextLine());
        int finalNum = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());

        int result = 0;
        int combinationCount = 0;
        for (int i = startNum; i <= finalNum ; i++) {
            for (int j = startNum; j <= finalNum ; j++) {
                result = i + j;
                combinationCount++;
                if (result == magicNum){
                    System.out.printf("Combination N:%d (%d + %d = %d)%n", combinationCount, i, j, result);
                    break;
                }
            }
            if (result == magicNum){
                break;
            }
        }
        if (result != magicNum){
            System.out.printf("%d combinations - neither equals %d%n", combinationCount, magicNum);
        }
    }
}
