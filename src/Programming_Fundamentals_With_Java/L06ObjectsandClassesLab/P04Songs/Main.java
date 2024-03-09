package Programming_Fundamentals_With_Java.L06ObjectsandClassesLab.P04Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Song> songs = new ArrayList<>();
        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfSongs ; i++) {
            String[] data = scanner.nextLine().split("_");
            String typeList = data[0];
            String name = data[1];
            String time = data[2];

            Song song = new Song(typeList, name, time);

            songs.add(song);
        }

        String filter = scanner.nextLine();
        boolean shouldFilter = !filter.equals("all");

        for (Song song : songs) {
            if (!shouldFilter) {
                System.out.println(song.getName());
            } else if (song.getTypeList().equals(filter)) {
                System.out.println(song.getName());
            }
        }
    }
}
