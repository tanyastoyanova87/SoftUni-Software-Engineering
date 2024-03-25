package Programming_Advanced_With_Java.JavaOOPExams.aquarium.repositories;

import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.decorations.Decoration;

public interface Repository  {
    void add(Decoration decoration);

    boolean remove(Decoration decoration);

    Decoration findByType(String type);
}
