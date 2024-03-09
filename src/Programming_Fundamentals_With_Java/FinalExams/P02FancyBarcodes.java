package Programming_Fundamentals_With_Java.FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("@#+([A-Z][A-Za-z0-9]{4,}[A-Z])@#+");
        List<String> barcodes = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                barcodes.add(matcher.group());
                String digitsBarcode = getDigits(barcodes);
                if (digitsBarcode.equals("")) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", digitsBarcode);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
    private static String getDigits(List<String> barcodes) {
        StringBuilder digits = new StringBuilder();
        for (String barcode : barcodes) {
            for (char symbol : barcode.toCharArray()) {
                if (Character.isDigit(symbol)) {
                    digits.append(symbol);
                }
            }
        }
        barcodes.remove(0);
        return digits.toString();
    }
}
