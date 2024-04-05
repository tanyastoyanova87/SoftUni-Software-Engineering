package Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.players;

import Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.guns.Gun;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.repositories.interfaces.GunRepository;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.repositories.interfaces.Repository;

import static Programming_Advanced_With_Java.JavaOOPExams.viceCity.common.ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO;
import static Programming_Advanced_With_Java.JavaOOPExams.viceCity.common.ExceptionMessages.PLAYER_NULL_USERNAME;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    public BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    private void setLifePoints(int lifePoints) {
        if (lifePoints < 0) {
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        this.lifePoints -= points;
        if (this.lifePoints < 0) {
            this.lifePoints = 0;
        }
    }
}
