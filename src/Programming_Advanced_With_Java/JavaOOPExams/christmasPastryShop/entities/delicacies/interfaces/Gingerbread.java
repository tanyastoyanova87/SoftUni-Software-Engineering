package Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.delicacies.interfaces;

public class Gingerbread extends BaseDelicacy {
    private static final double INITIAL_GINGER_BREAD_PORTION = 200;
    public Gingerbread(String name, double price) {
        super(name, INITIAL_GINGER_BREAD_PORTION, price);
    }
}
