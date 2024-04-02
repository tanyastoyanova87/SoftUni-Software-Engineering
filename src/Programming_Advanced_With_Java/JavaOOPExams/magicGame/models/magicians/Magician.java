package Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magicians;

import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magics.Magic;

public interface Magician {
    String getUsername();

    int getHealth();

    int getProtection();

    Magic getMagic();

    boolean isAlive();

    void takeDamage(int points);
}
