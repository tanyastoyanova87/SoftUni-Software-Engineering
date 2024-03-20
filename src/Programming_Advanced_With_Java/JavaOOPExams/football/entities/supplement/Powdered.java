package Programming_Advanced_With_Java.JavaOOPExams.football.entities.supplement;

public class Powdered extends BaseSupplement implements Supplement {
    private static final int ENERGY = 120;
    private static final double PRICE = 15;
    public Powdered() {
        super(ENERGY, PRICE);
    }
}
