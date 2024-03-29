package Programming_Advanced_With_Java.JavaOOPExams.bank.entities.bank;

public class CentralBank extends BaseBank {
    private static final int CAPACITY = 50;
    public CentralBank(String name) {
        super(name, CAPACITY);
    }
}
