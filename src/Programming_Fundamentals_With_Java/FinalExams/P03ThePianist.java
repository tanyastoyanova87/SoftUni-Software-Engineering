package Programming_Fundamentals_With_Java.FinalExams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> composerByPiece = new LinkedHashMap<>();
        Map<String, String> keyByPiece = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String pieces = scanner.nextLine();
            String piece = pieces.split("\\|")[0];
            String composer = pieces.split("\\|")[1];
            String key = pieces.split("\\|")[2];

            composerByPiece.put(piece, composer);
            keyByPiece.put(piece, key);
        }

        String commands = scanner.nextLine();
        while (!commands.equals("Stop")) {

            String[] commandsParts = commands.split("\\|");
            String command = commandsParts[0];
            String piece = commandsParts[1];

            if (command.equals("Add")) {
                String composer = commandsParts[2];
                String key = commandsParts[3];

                if (!composerByPiece.containsKey(piece) && !keyByPiece.containsKey(piece)) {
                    composerByPiece.put(piece, composer);
                    keyByPiece.put(piece, key);
                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                } else {
                    System.out.printf("%s is already in the collection!%n", piece);
                }
                
            } else if (command.equals("Remove")) {

                if (!composerByPiece.containsKey(piece) && !keyByPiece.containsKey(piece)) {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                } else {
                    composerByPiece.remove(piece);
                    keyByPiece.remove(piece);
                    System.out.printf("Successfully removed %s!%n", piece);
                }
                
            } else if (command.equals("ChangeKey")) {
                String newKey = commandsParts[2];

                if (keyByPiece.containsKey(piece)) {
                    keyByPiece.put(piece, newKey);
                    System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }

            }

            commands = scanner.nextLine();
        }

        for (String piece : composerByPiece.keySet()) {
            String composer = composerByPiece.get(piece);
            String key = keyByPiece.get(piece);

            System.out.printf("%s -> Composer: %s, Key: %s%n", piece, composer, key);
        }
    }
}
