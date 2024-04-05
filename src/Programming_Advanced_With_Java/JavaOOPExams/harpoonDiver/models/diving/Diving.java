package Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.diving;

import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.diver.Diver;
import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public interface Diving {

    void searching(DivingSite divingSite, Collection<Diver> divers);
}
