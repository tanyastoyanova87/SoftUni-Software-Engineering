package Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.diver;

import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.seaCatch.SeaCatch;

public interface Diver {

    String getName();

    double getOxygen();

    boolean canDive();

    SeaCatch getSeaCatch();

    void shoot();
}
