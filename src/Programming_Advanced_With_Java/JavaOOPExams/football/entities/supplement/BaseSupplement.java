package Programming_Advanced_With_Java.JavaOOPExams.football.entities.supplement;

public abstract class BaseSupplement implements Supplement {
    private int energy;
    private double price;

    public BaseSupplement(int energy, double price) {
        this.energy = energy;
        this.price = price;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}