package Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.diving;

import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.diver.Diver;
import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;


public class DivingImpl implements Diving {

    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {
        for (Diver diver : divers) {
            while (diver.canDive() && divingSite.getSeaCreatures().iterator().hasNext()) {
                diver.shoot();
                String seaCreature = divingSite.getSeaCreatures().iterator().next();
                diver.getSeaCatch().getSeaCreatures().add(seaCreature);
                divingSite.getSeaCreatures().remove(seaCreature);
            }
        }
    }
}
