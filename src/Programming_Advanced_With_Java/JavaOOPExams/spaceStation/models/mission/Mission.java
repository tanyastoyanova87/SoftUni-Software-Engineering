package Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.mission;

import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.astronauts.Astronaut;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.planets.Planet;

import java.util.Collection;

public interface Mission {
    void explore(Planet planet, Collection<Astronaut> astronauts);
}
