package Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.states;

import java.util.Collection;

public interface State {
    Collection<String> getExhibits();

    String getName();
}
