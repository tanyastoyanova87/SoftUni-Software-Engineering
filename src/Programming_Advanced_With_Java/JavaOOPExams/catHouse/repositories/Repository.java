package Programming_Advanced_With_Java.JavaOOPExams.catHouse.repositories;

import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.toys.Toy;

public interface Repository {

    void buyToy(Toy toy);

    boolean removeToy(Toy toy);

    Toy findFirst(String type);
}
