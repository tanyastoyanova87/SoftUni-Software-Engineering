package Programming_Advanced_With_Java.JavaOOPExams.handball.entities.equipment;

public class Kneepad extends BaseEquipment {
    private static final int PROTECTION = 120;
    private static final double PRICE = 15;
    public Kneepad() {
        super(PROTECTION, PRICE);
    }
}
