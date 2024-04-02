package Programming_Advanced_With_Java.JavaOOPExams.magicGame.repositories.interfaces;

import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static Programming_Advanced_With_Java.JavaOOPExams.magicGame.common.ExceptionMessages.INVALID_MAGICIAN_REPOSITORY;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {
    private Collection<Magician> magicians;

    public MagicianRepositoryImpl() {
        this.magicians = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return Collections.unmodifiableCollection(this.magicians);
    }

    @Override
    public void addMagician(Magician magician) {
        if (magician == null) {
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }
        this.magicians.add(magician);
    }

    @Override
    public boolean removeMagician(Magician magician) {
        return this.magicians.remove(magician);
    }

    @Override
    public Magician findByUsername(String name) {
        return this.magicians.stream().filter(magician -> magician.getUsername().equals(name)).findFirst().orElse(null);
    }
}
