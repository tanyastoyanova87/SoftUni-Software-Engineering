package Programming_Advanced_With_Java.JavaAdvancedExams.parking;

public class Main {
    public static void main(String[] args) {

        Parking parking = new Parking("Underground parking garage", 5);

// Initialize entity
        Car volvo = new Car("Volvo", "XC70", 2010);

// Print P01CarShopP02CarShopExtended.P06Ferrari.Programming_Advanced_With_Java.P01Vehicles.Programming_Advanced_With_Java.P02VehiclesExtension.Car
        System.out.println(volvo); // Volvo XC70 (2010)

// Add P01CarShopP02CarShopExtended.P06Ferrari.Programming_Advanced_With_Java.P01Vehicles.Programming_Advanced_With_Java.P02VehiclesExtension.Car
        parking.add(volvo);

// Remove P01CarShopP02CarShopExtended.P06Ferrari.Programming_Advanced_With_Java.P01Vehicles.Programming_Advanced_With_Java.P02VehiclesExtension.Car
        System.out.println(parking.remove("Volvo", "XC90")); // false
        System.out.println(parking.remove("Volvo", "XC70")); // true

        Car peugeot = new Car("Peugeot", "307", 2011);
        Car audi = new Car("P01CarShopP02CarShopExtended.Audi", "S4", 2005);

        parking.add(peugeot);

        parking.add(audi);

// Get Latest P01CarShopP02CarShopExtended.P06Ferrari.Programming_Advanced_With_Java.P01Vehicles.Programming_Advanced_With_Java.P02VehiclesExtension.Car
        Car latestCar = parking.getLatestCar();
        System.out.println(latestCar); // Peugeot 307 (2011)

// Get P01CarShopP02CarShopExtended.P06Ferrari.Programming_Advanced_With_Java.P01Vehicles.Programming_Advanced_With_Java.P02VehiclesExtension.Car
        Car audiS4 = parking.getCar("P01CarShopP02CarShopExtended.Audi", "S4");
        System.out.println(audiS4); // P01CarShopP02CarShopExtended.Audi S4 (2005)

// Count
        System.out.println(parking.getCount()); // 2

// Get Statistics
        System.out.println(parking.getStatistics());

    }
}
