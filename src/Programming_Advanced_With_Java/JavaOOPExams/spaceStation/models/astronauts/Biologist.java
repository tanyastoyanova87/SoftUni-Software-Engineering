package Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double OXYGEN = 70;
    public Biologist(String name) {
        super(name, OXYGEN);
    }

    @Override
    public void breath() {
        if (super.getOxygen() > 5) {
            super.setOxygen(super.getOxygen() - 5);
        } else {
            super.setOxygen(0);
        }
    }
}
