package Programming_Advanced_With_Java.JavaOOPExams.fairyShop.models;

public class Sleepy extends BaseHelper {
    private static int INITIAL_ENERGY = 50;
    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void work() {
        if (INITIAL_ENERGY - 5 < 0) {
            INITIAL_ENERGY = 0;
        } else {
            INITIAL_ENERGY -= 5;
        }
    }

}
