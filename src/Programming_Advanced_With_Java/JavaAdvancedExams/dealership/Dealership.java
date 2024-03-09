package Programming_Advanced_With_Java.JavaAdvancedExams.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    public String name;
    public int capacity;
    public List<Car> data;


    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
               return this.data.remove(car);
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car car = null;
        int latest = Integer.MIN_VALUE;
        for (Car currentCar : this.data) {
            if (currentCar.getYear() > latest) {
                latest = currentCar.getYear();
                car = currentCar;
            }
        }
        return car;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(" The cars are in a car dealership %s:%n", this.name));
        for (Car car : this.data) {
            sb.append(String.format("%s%n", car));
        }
        return sb.toString();
    }
}
