package Programming_Advanced_With_Java.L06DefiningClassesExercises.P05CarSalesman;

public class Engine {
    private String model;
    private int power; //мощност
    private int displacement; //работен обем
    private String efficiency; //ефективност

    //КОНСТРУКТОР -> ALT + INSERT
    public Engine(String model, int power, int displacement, String efficiency) {
        //нов празен обект
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
