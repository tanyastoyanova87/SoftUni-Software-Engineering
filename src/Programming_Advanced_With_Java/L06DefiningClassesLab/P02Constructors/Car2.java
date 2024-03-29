package Programming_Advanced_With_Java.L06DefiningClassesLab.P02Constructors;

public class Car2 {
    private String brand;
    public String model;
    private int horsePower;

    public Car2(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car2(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }
}
