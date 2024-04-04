package Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.mission;

import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.explorers.Explorer;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.states.State;


import java.util.Collection;

public interface Mission {
    void explore(State state, Collection<Explorer> explorers);
}
