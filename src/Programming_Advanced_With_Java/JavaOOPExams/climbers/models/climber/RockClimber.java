package Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climber;

public class RockClimber extends BaseClimber {
    private static double INITIAL_STRENGTH = 120;
    public RockClimber(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void climb() {
        this.setStrength(getStrength() - 60);
    }
}
