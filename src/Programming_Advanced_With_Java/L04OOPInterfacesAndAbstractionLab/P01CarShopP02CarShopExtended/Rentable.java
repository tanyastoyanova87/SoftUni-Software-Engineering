package Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionLab.P01CarShopP02CarShopExtended;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();
}
