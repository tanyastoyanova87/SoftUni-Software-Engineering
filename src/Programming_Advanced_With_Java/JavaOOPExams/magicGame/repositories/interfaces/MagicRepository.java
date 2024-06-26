package Programming_Advanced_With_Java.JavaOOPExams.magicGame.repositories.interfaces;

import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magics.Magic;

import java.util.Collection;

public interface MagicRepository<T> {
    Collection<T> getData();

    void addMagic(Magic model);

    boolean removeMagic(Magic model);

    T findByName(String name);
}
