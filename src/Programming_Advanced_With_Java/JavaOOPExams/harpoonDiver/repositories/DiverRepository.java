package Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.repositories;

import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.diver.Diver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiverRepository implements Repository<Diver> {
    private Collection<Diver> divers;

    public DiverRepository() {
        this.divers = new ArrayList<>();
    }

    @Override
    public Collection<Diver> getCollection() {
        return Collections.unmodifiableCollection(this.divers);
    }

    @Override
    public void add(Diver diver) {
        this.divers.add(diver);
    }

    @Override
    public boolean remove(Diver diver) {
        return this.divers.remove(diver);
    }

    @Override
    public Diver byName(String name) {
        for (Diver diver : this.divers) {
            if (diver.getName().equals(name)) {
                return diver;
            }
        }
        return null;
    }
}
