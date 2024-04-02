package Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magics;

import static Programming_Advanced_With_Java.JavaOOPExams.magicGame.common.ExceptionMessages.INVALID_MAGIC_BULLETS_COUNT;
import static Programming_Advanced_With_Java.JavaOOPExams.magicGame.common.ExceptionMessages.INVALID_MAGIC_NAME;

public abstract class MagicImpl implements Magic {
    private String name;
    private int bulletsCount;

    public MagicImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGIC_NAME);
        }
        this.name = name;
    }

    protected void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(INVALID_MAGIC_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    @Override
    public int fire() {
        return bulletsCount;
    }
}
