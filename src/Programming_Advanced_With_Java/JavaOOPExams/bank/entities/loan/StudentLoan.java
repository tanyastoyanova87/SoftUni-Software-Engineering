package Programming_Advanced_With_Java.JavaOOPExams.bank.entities.loan;

public class StudentLoan extends BaseLoan {
    private static final int INTEREST_RATE = 1;
    private static final double AMOUNT = 10_000;
    public StudentLoan() {
        super(INTEREST_RATE, AMOUNT);
    }
}
