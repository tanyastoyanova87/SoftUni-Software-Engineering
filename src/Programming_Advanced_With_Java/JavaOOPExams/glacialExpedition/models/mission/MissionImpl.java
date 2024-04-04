package Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.mission;

import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.explorers.Explorer;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        Collection<String> exhibits = state.getExhibits();

        for (Explorer explorer : explorers) {
            while (explorer.canSearch() && exhibits.iterator().hasNext()) {
                explorer.search();
                String exhibit = exhibits.iterator().next();
                explorer.getSuitcase().getExhibits().add(exhibit);
                exhibits.remove(exhibit);
            }
        }
    }
}
