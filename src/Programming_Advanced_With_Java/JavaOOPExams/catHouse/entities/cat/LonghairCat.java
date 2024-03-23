package Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.cat;

public class LonghairCat extends BaseCat {
    private static int INITIAL_KILOGRAMS = 9;
    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        this.setKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        setKilograms(INITIAL_KILOGRAMS + 3);
    }
}
