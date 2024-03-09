package Programming_Advanced_With_Java.L01OOPWorkingWithAbstractionExercises.P04TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Signals[] signals = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Signals::valueOf)
                .toArray(Signals[]::new);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            Signals.updateSignals(signals);
            Signals.printSignals(signals);
        }
    }
}
