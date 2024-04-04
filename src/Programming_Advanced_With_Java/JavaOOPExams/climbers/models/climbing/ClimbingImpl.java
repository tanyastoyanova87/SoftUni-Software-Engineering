package Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climbing;

import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climber.Climber;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.mountain.Mountain;

import java.util.Collection;

public class ClimbingImpl implements Climbing {

    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {
        Collection<String> peaksList = mountain.getPeaksList();

        for (Climber climber : climbers) {
            while (climber.canClimb() && peaksList.iterator().hasNext()) {
                climber.climb();
                String peak = peaksList.iterator().next();
                climber.getRoster().getPeaks().add(peak);
                peaksList.remove(peak);
            }
        }
    }
}
