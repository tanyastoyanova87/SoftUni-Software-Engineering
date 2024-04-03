package Programming_Advanced_With_Java.JavaOOPExams.zoo.core;

import Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.animals.Animal;
import Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.animals.AquaticAnimal;
import Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.animals.TerrestrialAnimal;
import Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.areas.Area;
import Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.areas.LandArea;
import Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.areas.WaterArea;
import Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.foods.Food;
import Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.foods.Meat;
import Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.foods.Vegetable;
import Programming_Advanced_With_Java.JavaOOPExams.zoo.repositories.FoodRepository;
import Programming_Advanced_With_Java.JavaOOPExams.zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import static Programming_Advanced_With_Java.JavaOOPExams.zoo.common.ConstantMessages.*;
import static Programming_Advanced_With_Java.JavaOOPExams.zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        switch (areaType) {
            case "LandArea":
                area = new LandArea(areaName);
                break;
            case "WaterArea":
                area = new WaterArea(areaName);
                break;
            default:
                throw new NullPointerException(INVALID_AREA_TYPE);
        }

        this.areas.add(area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        switch (foodType) {
            case "Meat":
                food = new Meat();
                break;
            case "Vegetable":
                food = new Vegetable();
                break;
            default:
                throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        this.foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Area area = this.areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
        Food food = this.foodRepository.findByType(foodType);
        if (food == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }

        assert area != null;
        area.addFood(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Area area = this.areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
        Animal animal;
        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }

        if (animalType.equals("AquaticAnimal") && Objects.requireNonNull(area).getClass().getSimpleName().equals("LandArea")) {
            return AREA_NOT_SUITABLE;
        } else {
            if (animalType.equals("TerrestrialAnimal")) {
                assert area != null;
                if (area.getClass().getSimpleName().equals("WaterArea")) {
                    return AREA_NOT_SUITABLE;
                }
            }
        }

        area.addAnimal(animal);
        return String.format(String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName));
    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = this.areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
        assert area != null;
        area.getAnimals().forEach(Animal::eat);
        return String.format(ANIMALS_FED, area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = this.areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
        assert area != null;
        double calculation = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();
        return String.format(KILOGRAMS_AREA, areaName, calculation);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Area area : areas) {
            sb.append(area.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
