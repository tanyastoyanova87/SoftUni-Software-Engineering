package Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climbing;

import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climber.Climber;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.mountain.Mountain;

import java.util.Collection;

public interface Climbing {
    void conqueringPeaks(Mountain mountain, Collection<Climber> climbers);

}
