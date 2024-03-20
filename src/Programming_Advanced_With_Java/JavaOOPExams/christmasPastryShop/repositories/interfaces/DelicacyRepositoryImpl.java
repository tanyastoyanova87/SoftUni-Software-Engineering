package Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.repositories.interfaces;

import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy>{
private Collection<Delicacy> delicacies;

    public DelicacyRepositoryImpl() {
        this.delicacies = new ArrayList<>();
    }

    @Override
    public Delicacy getByName(String name) {
        return this.delicacies.stream()
                .filter(delicacy -> delicacy.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Delicacy> getAll() {
        return Collections.unmodifiableCollection(delicacies);
    }

    @Override
    public void add(Delicacy delicacy) {
        this.delicacies.add(delicacy);
    }
}
