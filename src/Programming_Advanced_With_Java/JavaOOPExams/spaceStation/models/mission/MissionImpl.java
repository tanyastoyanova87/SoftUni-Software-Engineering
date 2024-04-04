package Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.mission;

import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.astronauts.Astronaut;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission{
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Collection<String> items = planet.getItems();
        for (Astronaut astronaut : astronauts) {
            while (astronaut.canBreath() && items.iterator().hasNext()) {
                astronaut.breath();
                String item = items.iterator().next();
                astronaut.getBag().getItems().add(item);
                planet.getItems().remove(item);
            }
        }
    }
}
