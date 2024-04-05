package Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.players;

import Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.guns.Gun;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
