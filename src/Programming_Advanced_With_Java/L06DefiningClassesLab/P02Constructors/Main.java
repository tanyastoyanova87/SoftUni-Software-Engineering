package Programming_Advanced_With_Java.L06DefiningClassesLab.P02Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Car2 car;

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input.length == 1) {
                car = new Car2(input[0]);
            } else {
                String brand = input[0];
                String model = input[1];
                int horsePower = Integer.parseInt(input[2]);
                car = new Car2(brand, model, horsePower);
            }
            System.out.println(car.carInfo());
        }
    }
}
