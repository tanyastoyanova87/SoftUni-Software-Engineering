package Programming_Advanced_With_Java.JavaOOPExams.zoo.repositories;

import Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.foods.Food;

public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
