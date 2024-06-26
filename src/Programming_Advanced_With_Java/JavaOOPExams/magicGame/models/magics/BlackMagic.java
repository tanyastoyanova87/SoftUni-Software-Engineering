package Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magics;

public class BlackMagic extends MagicImpl {
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() < 10) {
            return 0;
        }
        setBulletsCount(getBulletsCount() - 10);
        return getBulletsCount();
    }
}
