package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P05SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int pen = Integer.parseInt(scanner.nextLine());
       int highlighters = Integer.parseInt(scanner.nextLine());
       int cleaner = Integer.parseInt(scanner.nextLine());
       int percentDiscount = Integer.parseInt(scanner.nextLine());

       double penPrice = pen * 5.80;
       double highPrice = highlighters * 7.20;
       double cleanerPrice = cleaner * 1.20;

       double full = penPrice + highPrice + cleanerPrice;
       double discountPrice = full * (percentDiscount / 100.0);
       double finalSum = full - discountPrice;

       System.out.println(finalSum);

    }
}
