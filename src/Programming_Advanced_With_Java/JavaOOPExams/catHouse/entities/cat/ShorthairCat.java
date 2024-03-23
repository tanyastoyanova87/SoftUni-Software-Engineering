package Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.cat;

public class ShorthairCat extends BaseCat {
    private static int INITIAL_KILOGRAMS = 7;
    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        this.setKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        setKilograms(INITIAL_KILOGRAMS + 1);
    }
}
