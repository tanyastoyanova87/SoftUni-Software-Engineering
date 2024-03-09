package Programming_Fundamentals_With_Java.L05ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> text = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {

            String[] commandSplit = command.split(" ");
            if (command.contains("merge")) {
                int startIndex = Integer.parseInt(commandSplit[1]);
                int endIndex = Integer.parseInt(commandSplit[2]);

                if (startIndex < 0) {
                    startIndex = 0;
                }

                if (endIndex > text.size() - 1) {
                    endIndex = text.size() - 1;
                }

                if (startIndex >= 0 && startIndex <= text.size() - 1 && endIndex >= 0 && endIndex <= text.size() - 1) {
                    String resultMerge = "";

                    for (int i = startIndex; i <= endIndex ; i++) {
                        String current = text.get(i);
                        resultMerge += current;
                    }

                    for (int i = startIndex; i <= endIndex ; i++) {
                        text.remove(startIndex);
                    }

                    text.add(startIndex, resultMerge);

                }
            } else if (command.contains("divide")) {

                int index = Integer.parseInt(commandSplit[1]);
                int parts = Integer.parseInt(commandSplit[2]);

                if (index >= 0 && index <= text.size() - 1) {
                    String textForDivide = text.get(index);
                    text.remove(index);

                    int countSymbolsPerPart = textForDivide.length() / parts;

                    int beginIndex = 0;
                    for (int part = 1; part < parts; part++) {
                        String textPerPart = textForDivide.substring(beginIndex, beginIndex + countSymbolsPerPart);
                        text.add(index, textPerPart);
                        index++;
                        beginIndex += countSymbolsPerPart;
                    }

                    String textLastParts = textForDivide.substring(beginIndex, textForDivide.length());
                    text.add(index, textLastParts);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(" ", text));
    }
}
