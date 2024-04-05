package Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.repositories;

import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.divingSite.DivingSite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DivingSiteRepository implements Repository<DivingSite> {
    private Collection<DivingSite> divingSites;

    public DivingSiteRepository() {
        this.divingSites = new ArrayList<>();
    }

    @Override
    public Collection<DivingSite> getCollection() {
        return Collections.unmodifiableCollection(this.divingSites);
    }

    @Override
    public void add(DivingSite divingSite) {
        this.divingSites.add(divingSite);
    }


    @Override
    public boolean remove(DivingSite divingSite) {
        return this.divingSites.remove(divingSite);
    }


    @Override
    public DivingSite byName(String name) {
        for (DivingSite divingSite : this.divingSites) {
            if (divingSite.getName().equals(name)) {
                return divingSite;
            }
        }
        return null;
    }
}
