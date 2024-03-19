package Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.models.units;

public class Gunner extends AbstractUnit {
    private static final int HORSEMAN_HEALTH = 20;
    private static final int HORSEMAN_DAMAGE = 20;
    protected Gunner() {
        super(HORSEMAN_HEALTH, HORSEMAN_DAMAGE);
    }
}
