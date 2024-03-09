package Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionLab.P05BorderControl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> ids = new HashMap<>();

        String line = scanner.nextLine();
        while (!"End".equals(line)) {

            String[] tokens = line.split("\\s+");

            if (tokens.length == 2) {
                String id = tokens[1];
                String lastIdDigits = getLastIdDigits(id);
                ids.put(tokens[1], lastIdDigits);
            } else {
                String id = tokens[2];
                String lastIdDigits = getLastIdDigits(id);
                ids.put(tokens[2], lastIdDigits);
            }

            line = scanner.nextLine();

        }

        String fakeId = scanner.nextLine();
        printInvalidIds(ids, fakeId);

    }

    private static void printInvalidIds(Map<String, String> ids, String fakeId) {
        for (Map.Entry<String, String> entry : ids.entrySet()) {
            if (fakeId.equals(entry.getValue())) {
                System.out.println(entry.getKey());
            }
        }
    }

    private static String getLastIdDigits(String id) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < id.length(); i++) {
            char symbol = id.charAt(i);
            list.add(String.valueOf(symbol));
        }

        getLast3Digits(id, sb, list);
        return sb.toString();
    }

    private static void getLast3Digits(String id, StringBuilder sb, List<String> list) {
        String last = list.get(id.length() - 1);
        String previous = list.get(id.length() - 2);
        String doublePrevious = list.get(id.length() - 3);
        sb.append(doublePrevious);
        sb.append(previous);
        sb.append(last);
    }

}
