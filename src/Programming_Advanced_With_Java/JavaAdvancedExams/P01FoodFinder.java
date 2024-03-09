package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;

public class P01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> vowelsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(vowelsQueue::offer);

        Deque<String> consonantsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consonantsStack::push);

        List<Character> vowelsAndConsonants = new ArrayList<>();
        String pear = "pear";
        String flour = "flour";
        String pork = "pork";
        String olive = "olive";
        while (!consonantsStack.isEmpty()) {

            String currentVowel = vowelsQueue.peek();
            String currentConsonant = consonantsStack.peek();
            vowelsQueue.poll();
            vowelsQueue.offer(currentVowel);
            consonantsStack.pop();
            if (pear.contains(currentVowel)) {
                vowelsAndConsonants.add(currentVowel.charAt(0));
            }
            if (flour.contains(currentVowel)) {
                vowelsAndConsonants.add(currentVowel.charAt(0));
            }
            if (pork.contains(currentVowel)) {
                vowelsAndConsonants.add(currentVowel.charAt(0));
            }
            if (olive.contains(currentVowel)) {
                vowelsAndConsonants.add(currentVowel.charAt(0));
            }
            if (pear.contains(currentConsonant)) {
                vowelsAndConsonants.add(currentConsonant.charAt(0));
            }
            if (flour.contains(currentConsonant)) {
                vowelsAndConsonants.add(currentConsonant.charAt(0));
            }
            if (pork.contains(currentConsonant)) {
                vowelsAndConsonants.add(currentConsonant.charAt(0));
            }
            if (olive.contains(currentConsonant)) {
                vowelsAndConsonants.add(currentConsonant.charAt(0));
            }
        }
        List<String> foundWords = new ArrayList<>();
        int foundWordsCount = 0;
        boolean notFound = false;
        for (char c : pear.toCharArray()) {
            if (!vowelsAndConsonants.contains(c)) {
                notFound = true;
                break;
            }
        }
        if (!notFound) {
            foundWords.add(pear);
            foundWordsCount++;
        }

        notFound = false;
        for (char c : flour.toCharArray()) {
            if (!vowelsAndConsonants.contains(c)) {
                notFound = true;
                break;
            }
        }
        if (!notFound) {
            foundWords.add(flour);
            foundWordsCount++;
        }

        notFound = false;
        for (char c : pork.toCharArray()) {
            if (!vowelsAndConsonants.contains(c)) {
                notFound = true;
                break;
            }
        }
        if (!notFound) {
            foundWords.add(pork);
            foundWordsCount++;
        }

        notFound = false;
        for (char c : olive.toCharArray()) {
            if (!vowelsAndConsonants.contains(c)) {
                notFound = true;
                break;
            }
        }
        if (!notFound) {
            foundWords.add(olive);
            foundWordsCount++;
        }

        System.out.printf("Words found: %d%n", foundWordsCount);
        foundWords.forEach(System.out::println);
    }
}
