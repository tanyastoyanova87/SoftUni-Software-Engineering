package Programming_Advanced_With_Java.JavaOOPExams.catHouse.core;

import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.cat.Cat;
import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.cat.LonghairCat;
import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.cat.ShorthairCat;
import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.houses.House;
import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.houses.LongHouse;
import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.houses.ShortHouse;
import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.toys.Ball;
import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.toys.Mouse;
import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.toys.Toy;
import Programming_Advanced_With_Java.JavaOOPExams.catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static Programming_Advanced_With_Java.JavaOOPExams.catHouse.common.ConstantMessages.*;
import static Programming_Advanced_With_Java.JavaOOPExams.catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository<Toy> toyRepository;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toyRepository = new ToyRepository<>();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }

        this.houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }

        this.toyRepository.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toyRepository.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        for (House house : this.houses) {
            if (house.getName().equals(houseName)) {
                house.buyToy(toy);
                this.toyRepository.removeToy(toy);
            }
        }
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        for (House house : this.houses) {
            if (house.getName().equals(houseName)) {
                if (house.getClass().getSimpleName().equals("ShortHouse") && house.getName().equals(houseName) && catType.equals("LonghairCat")) {
                    return "Unsuitable house.";
                } else if (house.getClass().getSimpleName().equals("LongHouse") && house.getName().equals(houseName) && catType.equals("ShorthairCat")) {
                    return "Unsuitable house.";
                } else {
                    house.addCat(cat);
                }
            }
        }
        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        int count = 0;
        for (House house : this.houses) {
            if (house.getName().equals(houseName)) {
                for (Cat cat : house.getCats()) {
                    cat.eating();
                    count++;
                }
            }
        }
        return String.format(FEEDING_CAT, count);
    }

    @Override
    public String sumOfAll(String houseName) {
        double price = 0;
        for (House house : this.houses) {
            if (house.getName().equals(houseName)) {
                double catsSum = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
                double toysSum = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
                price = catsSum + toysSum;
            }
        }
        return String.format(VALUE_HOUSE, houseName, price);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (House house : this.houses) {
            sb.append(house.getStatistics());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
