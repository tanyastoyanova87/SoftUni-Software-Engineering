package Programming_Advanced_With_Java.JavaAdvancedExams.halloween;

public class Main {
    public static void main(String[] args) {

        House house = new House(6);

        Kid firstKid = new Kid("Stefan", 11, "Ilinden");

        System.out.println(firstKid);

        house.addKid(firstKid);

        System.out.println(house.removeKid("Peter"));
        System.out.println(house.removeKid("Stefan"));

        Kid secondKid = new Kid("Toni", 15, "Chudomir Kantardjiev");
        Kid thirdKid = new Kid("Ivana",12, "Pirin");
        Kid fourthdKid = new Kid("Ivan",13, "Solunska");

        house.addKid(secondKid);
        house.addKid(thirdKid);
        house.addKid(fourthdKid);

        Kid kid = house.getKid("Pirin");
        System.out.println(kid);

        System.out.println(house.getAllKids());

        System.out.println(house.getStatistics());
    }
}
