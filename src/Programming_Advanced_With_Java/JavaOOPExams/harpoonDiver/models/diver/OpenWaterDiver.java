package Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.diver;

public class OpenWaterDiver extends BaseDiver {

    private static final double INITIAL_UNITS_OF_OXYGEN = 30;
    public OpenWaterDiver(String name) {
        super(name, INITIAL_UNITS_OF_OXYGEN);
    }
}
