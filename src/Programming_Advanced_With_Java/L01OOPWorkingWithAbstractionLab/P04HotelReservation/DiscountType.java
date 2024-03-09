package Programming_Advanced_With_Java.L01OOPWorkingWithAbstractionLab.P04HotelReservation;

public enum DiscountType {
    VIP(20),
    SecondVisit(10),
    None(0);
    private int discount;

    DiscountType(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }
}
