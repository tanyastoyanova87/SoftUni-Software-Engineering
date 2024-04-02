package Programming_Advanced_With_Java.JavaOOPExams.magicGame.repositories.interfaces;

import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magicians.Magician;

import java.util.Collection;

public interface


MagicianRepository<T> {
    Collection<T> getData();

    void addMagician(Magician model);

    boolean removeMagician(Magician model);

    T findByUsername(String name);
}
