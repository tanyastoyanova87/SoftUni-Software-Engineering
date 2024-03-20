package Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.booths.interfaces;

import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

import static Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseBooth implements Booth {
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
    }

    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        isReserved = true;
        this.price = numberOfPeople * this.pricePerPerson;
    }

    @Override
    public double getBill() {
        double cocktails = this.cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
        double delicacies = this.delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        return cocktails + delicacies + getPrice();
    }

    @Override
    public void clear() {
        this.delicacyOrders.clear();
        this.cocktailOrders.clear();
        this.numberOfPeople = 0;
        this.price = 0;
        isReserved = false;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }


}
