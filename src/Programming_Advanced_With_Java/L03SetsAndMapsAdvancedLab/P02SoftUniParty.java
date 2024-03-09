package Programming_Advanced_With_Java.L03SetsAndMapsAdvancedLab;

import java.util.*;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        String guest = scanner.nextLine();
        while (!"PARTY".equals(guest)) {

            char[] guestChars = guest.toCharArray();
            if (Character.isDigit(guestChars[0])) {
                vipGuests.add(guest);
            } else {
                regularGuests.add(guest);
            }

            guest = scanner.nextLine();
        }

        String guestsComing = scanner.nextLine();
        while (!"END".equals(guestsComing)) {

            vipGuests.remove(guestsComing);
            regularGuests.remove(guestsComing);

            guestsComing = scanner.nextLine();
        }

        System.out.println(vipGuests.size() + regularGuests.size());
        for (String guests : vipGuests) {
            System.out.println(guests);
        }

        for (String guests : regularGuests) {
            System.out.println(guests);
        }
    }
}
