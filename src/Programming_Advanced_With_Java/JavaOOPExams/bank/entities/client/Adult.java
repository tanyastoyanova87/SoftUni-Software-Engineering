package Programming_Advanced_With_Java.JavaOOPExams.bank.entities.client;

public class Adult extends BaseClient {
    private static int INITIAL_INTEREST = 4;
    public Adult(String name, String ID, double income) {
        super(name, ID, INITIAL_INTEREST, income);
    }

    @Override
    public void increase() {
        setInterest(getInterest() + 2 );
    }
}
