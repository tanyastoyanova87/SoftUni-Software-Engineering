package Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.core;

import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.common.enums.BoothType;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.common.enums.CocktailType;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.common.enums.DelicacyType;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.core.interfaces.Controller;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.booths.interfaces.OpenBooth;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.booths.interfaces.Booth;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.delicacies.interfaces.Stolen;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.repositories.interfaces.*;

import static Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository,
                          BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.totalIncome = 0;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = delicacyRepository.getByName(name);

        if (delicacy == null) {
            DelicacyType delicacyType = DelicacyType.valueOf(String.valueOf(type));
            switch (delicacyType) {
                case Gingerbread:
                    delicacy = new Gingerbread(name, price);
                    break;
                case Stolen:
                    delicacy = new Stolen(name, price);
                    break;
            }
        } else {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        this.delicacyRepository.add(delicacy);
        return String.format(DELICACY_ADDED, name, type);
    }


    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = this.cocktailRepository.getByName(name);

        if (cocktail == null) {
            CocktailType cocktailType = CocktailType.valueOf(type);
            switch (cocktailType) {
                case Hibernation:
                    cocktail = new Hibernation(name, size, brand);
                    break;
                case MulledWine:
                    cocktail = new MulledWine(name, size, brand);
                    break;
            }
        } else {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        this.cocktailRepository.add(cocktail);
        return String.format(COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = this.boothRepository.getByNumber(boothNumber);

        if (booth == null) {
            BoothType boothType = BoothType.valueOf(type);
            switch (boothType) {
                case PrivateBooth:
                    booth = new PrivateBooth(boothNumber, capacity);
                    break;
                case OpenBooth:
                    booth = new OpenBooth(boothNumber, capacity);
                    break;
            }
        } else {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
        }

        this.boothRepository.add(booth);
        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth availableBooth = this.boothRepository.getAll().stream()
                .filter(booth -> !booth.isReserved()
                        && booth.getCapacity() >= numberOfPeople)
                .findFirst().orElse(null);

        if (availableBooth == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        } else {
            availableBooth.reserve(numberOfPeople);
            return String.format(BOOTH_RESERVED, availableBooth.getBoothNumber(), numberOfPeople);
        }
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth1 = boothRepository.getByNumber(boothNumber);

        double bill = booth1.getBill();
        this.totalIncome += bill;
        booth1.clear();

        return String.format(BILL, boothNumber, bill);
    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME, this.totalIncome);
    }
}
