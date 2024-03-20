package Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.repositories.interfaces;

import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BoothRepositoryImpl implements BoothRepository<Booth> {
    private Collection<Booth> booths;

    public BoothRepositoryImpl() {
        this.booths = new ArrayList<>();
    }

    @Override
    public Booth getByNumber(int number) {
        return booths.stream()
                .filter(booth -> booth.getBoothNumber() == number)
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableCollection(this.booths);
    }

    @Override
    public void add(Booth booth) {
        this.booths.add(booth);
    }
}
