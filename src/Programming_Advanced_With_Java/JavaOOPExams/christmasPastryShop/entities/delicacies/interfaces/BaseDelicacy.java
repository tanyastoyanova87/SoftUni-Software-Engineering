package Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.delicacies.interfaces;


import static Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseDelicacy implements Delicacy {
    private String name;
    private double portion;
    private double price;

    public BaseDelicacy(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2flv", name, portion, price);
    }
}
