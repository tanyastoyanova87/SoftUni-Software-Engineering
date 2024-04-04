package Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climber;

import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.roster.Roster;

public interface Climber {
    String getName();

    double getStrength();

    boolean canClimb();

    Roster getRoster();


    void climb();
}
