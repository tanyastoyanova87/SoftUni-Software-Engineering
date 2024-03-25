package Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.aquariums;

import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.decorations.Decoration;
import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.fish.Fish;

import java.util.Collection;

public interface Aquarium {
    int calculateComfort();

    String getName();

    void addFish(Fish fish);

    void removeFish(Fish fish);

    void addDecoration(Decoration decoration);

    void feed();

    String getInfo();

    Collection<Fish> getFish();

    Collection<Decoration> getDecorations();
}
