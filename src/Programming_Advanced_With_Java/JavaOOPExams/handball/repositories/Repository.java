package Programming_Advanced_With_Java.JavaOOPExams.handball.repositories;

import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.equipment.Equipment;

public interface Repository {
    void add(Equipment equipment);
    boolean remove(Equipment equipment);
    Equipment findByType(String type);
}
