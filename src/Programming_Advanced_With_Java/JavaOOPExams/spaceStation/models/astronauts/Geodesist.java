package Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut {
    private static final double OXYGEN = 50;
    public Geodesist(String name) {
        super(name, OXYGEN);
    }
}
