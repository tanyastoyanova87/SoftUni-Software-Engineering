package Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.foods;

public class Meat extends BaseFood {
    private static final int CALORIES = 70;
    private static final double PRICE = 10;
    public Meat() {
        super(CALORIES, PRICE);
    }
}
