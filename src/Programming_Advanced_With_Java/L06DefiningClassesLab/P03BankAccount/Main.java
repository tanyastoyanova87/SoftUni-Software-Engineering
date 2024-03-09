package Programming_Advanced_With_Java.L06DefiningClassesLab.P03BankAccount;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<Integer, BankAccount> accounts = new TreeMap<>();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {

            String[] data = input.split("\\s+");
            String command = data[0];
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    accounts.putIfAbsent(bankAccount.getId(), bankAccount);
                    System.out.printf("Account ID%d created%n", bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(data[1]);
                    double amount = Double.parseDouble(data[2]);
                    if (accounts.containsKey(id)) {
                        accounts.get(id).deposit(amount);
                        System.out.printf("Deposited %s to ID%d%n", new DecimalFormat("#.##").format(amount), id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;

                case "SetInterest":
                    double interest = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(interest);
                    break;

                case "GetInterest":
                    int id1 = Integer.parseInt(data[1]);
                    int years = Integer.parseInt(data[2]);
                    if (accounts.containsKey(id1)) {
                        double interest1 = accounts.get(id1).getInterest(years);
                        System.out.printf("%.2f%n", interest1);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
