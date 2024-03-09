package Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionLab.P01CarShopP02CarShopExtended;

public interface Car {
    int TIRES = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
