package Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.astronauts;

import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.bags.Bag;

public interface Astronaut {
    String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
