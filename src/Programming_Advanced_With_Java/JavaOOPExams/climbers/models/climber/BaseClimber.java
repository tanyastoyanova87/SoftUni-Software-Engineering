package Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climber;

import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.roster.Roster;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.roster.RosterImpl;

import static Programming_Advanced_With_Java.JavaOOPExams.climbers.common.ExceptionMessages.CLIMBER_NAME_NULL_OR_EMPTY;
import static Programming_Advanced_With_Java.JavaOOPExams.climbers.common.ExceptionMessages.CLIMBER_STRENGTH_LESS_THAN_ZERO;

public abstract class BaseClimber implements Climber {
    private String name;
    private double strength;
    private Roster roster;

    public BaseClimber(String name, double strength) {
        this.setName(name);
        this.setStrength(strength);
        this.roster = new RosterImpl();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(CLIMBER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setStrength(double strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getStrength() {
        return this.strength;
    }

    @Override
    public boolean canClimb() {
        return strength > 0;
    }

    @Override
    public Roster getRoster() {
        return this.roster;
    }

    @Override
    public void climb() {

    }
}
