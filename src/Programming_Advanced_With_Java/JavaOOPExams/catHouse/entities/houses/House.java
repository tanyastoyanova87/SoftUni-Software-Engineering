package Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.houses;

import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.cat.Cat;
import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.toys.Toy;

import java.util.Collection;

public interface House {
    int sumSoftness();

    void addCat(Cat cat);

    void removeCat(Cat cat);

    void buyToy(Toy toy);

    void feeding();

    String getStatistics();

    String getName();

    void setName(String name);

    Collection<Cat> getCats();

    Collection<Toy> getToys();
}
