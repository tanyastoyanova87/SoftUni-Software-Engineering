package Programming_Advanced_With_Java.JavaOOPExams.climbers.repositories;

import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climber.Climber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ClimberRepository implements Repository<Climber> {
    private Collection<Climber> climbers;

    public ClimberRepository() {
        this.climbers = new ArrayList<>();
    }
    @Override
    public Collection<Climber> getCollection() {
        return Collections.unmodifiableCollection(this.climbers);
    }

    @Override
    public void add(Climber climber) {
        this.climbers.add(climber);
    }

    @Override
    public boolean remove(Climber climber) {
        return this.climbers.remove(climber);
    }

    @Override
    public Climber byName(String name) {
        return this.climbers.stream().filter(climber -> climber.getName().equals(name))
                .findFirst().orElse(null);
    }
}
