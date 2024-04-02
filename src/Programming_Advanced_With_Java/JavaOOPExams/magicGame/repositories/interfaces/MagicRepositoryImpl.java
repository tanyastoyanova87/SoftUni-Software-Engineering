package Programming_Advanced_With_Java.JavaOOPExams.magicGame.repositories.interfaces;

import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static Programming_Advanced_With_Java.JavaOOPExams.magicGame.common.ExceptionMessages.INVALID_MAGIC_REPOSITORY;

public class MagicRepositoryImpl implements MagicRepository<Magic> {
    private Collection<Magic> magics;

    public MagicRepositoryImpl() {
        this.magics = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return Collections.unmodifiableCollection(this.magics);
    }

    @Override
    public void addMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC_REPOSITORY);
        }
        this.magics.add(magic);
    }

    @Override
    public boolean removeMagic(Magic magic) {
        return this.magics.remove(magic);
    }

    @Override
    public Magic findByName(String name) {
        return this.magics.stream().filter(magic -> magic.getName().equals(name)).findFirst().orElse(null);
    }
}
