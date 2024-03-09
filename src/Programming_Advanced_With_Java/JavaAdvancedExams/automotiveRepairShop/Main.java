package Programming_Advanced_With_Java.JavaAdvancedExams.automotiveRepairShop;

public class Main {
    public static void main(String[] args) {

        RepairShop repairShop = new RepairShop(5);

        Vehicle vehicle1 = new Vehicle("46546460", 2000, "Oil leakage");

        System.out.println(vehicle1);

        repairShop.addVehicle(vehicle1);

        System.out.println(repairShop.removeVehicle("4546548"));
        System.out.println(repairShop.removeVehicle("46546460"));

        Vehicle vehicle2 = new Vehicle("46846848468468", 5000, "Piston damage");
        Vehicle vehicle3 = new Vehicle("213115456", 3000, "Coolant leakage");
        Vehicle vehicle4 = new Vehicle("486876884522121325", 6000, "Overheating issue");
        Vehicle vehicle5 = new Vehicle("1234565232", 10000, "Timing belt failure");

        repairShop.addVehicle(vehicle2);
        repairShop.addVehicle(vehicle3);
        repairShop.addVehicle(vehicle4);
        repairShop.addVehicle(vehicle5);

        System.out.println(repairShop.getCount());

        System.out.println(repairShop.getLowestMileage());

        System.out.println(repairShop.report());
    }
}
