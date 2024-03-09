package Programming_Fundamentals_With_Java.L06ObjectsAndClassesExercise.P05VehicleCatalogue;

public class Vehicle {

    private String typeOfVehicle;
    private String model;
    private String color;
    private int horsepower;

    public Vehicle(String typeOfVehicle, String model, String color, int horsepower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }


    public String getTypeOfVehicle() {
        return this.typeOfVehicle;
    }

    public void setTypeOfVehicle (String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    @Override
    public String toString() {
        String formattedType = "";
        if (this.typeOfVehicle.equals("car")) {
            formattedType = "Car";
        } else if (this.typeOfVehicle.equals("truck")) {
            formattedType = "Truck";
        }
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %s", formattedType, this.model, this.color, this.horsepower);
    }
}
