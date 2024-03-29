package Programming_Advanced_With_Java.JavaOOPExams.bank.entities.client;

public class Student extends BaseClient {
    private static int INITIAL_INTEREST = 2;
    public Student(String name, String ID, double income) {
        super(name, ID, INITIAL_INTEREST, income);
    }

    @Override
    public void increase() {
        setInterest(getInterest() + 1);
    }
}
