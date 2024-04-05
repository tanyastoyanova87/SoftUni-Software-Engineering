package Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.guns;

public class Rifle extends BaseGun {
    public static final int BULLETS_PER_SHOT = 5;
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel() < BULLETS_PER_SHOT) {
            if (getTotalBullets() > BULLETS_PER_BARREL) {
                setTotalBullets(getTotalBullets() - (BULLETS_PER_BARREL - getBulletsPerBarrel()));
                setBulletsPerBarrel(BULLETS_PER_BARREL);
            } else {
                setBulletsPerBarrel(getTotalBullets());
                setTotalBullets(0);
            }
        }
        setBulletsPerBarrel(getBulletsPerBarrel() - BULLETS_PER_SHOT);
        return BULLETS_PER_SHOT;
    }
}
