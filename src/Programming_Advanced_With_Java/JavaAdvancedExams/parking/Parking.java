package Programming_Advanced_With_Java.JavaAdvancedExams.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    //•	type: String
    //•	capacity: int

    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
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
        for (Car car1 : this.data) {
            if (car1.getYear() > latest) {
                latest = car1.getYear();
                car = car1;
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
        sb.append(String.format("The cars are parked in %s:%n", this.type));
        for (Car car : this.data) {
            sb.append(car).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
