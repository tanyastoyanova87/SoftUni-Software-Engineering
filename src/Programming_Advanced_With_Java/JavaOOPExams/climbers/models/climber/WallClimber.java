package Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climber;

public class WallClimber extends BaseClimber {
    private static double INITIAL_STRENGTH = 90;
    public WallClimber(String name) {
        super(name, INITIAL_STRENGTH);
    }
    @Override
    public void climb() {
        this.setStrength(getStrength() - 30);
    }
}
