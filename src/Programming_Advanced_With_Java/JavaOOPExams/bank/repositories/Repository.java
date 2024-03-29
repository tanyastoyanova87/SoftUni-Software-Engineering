package Programming_Advanced_With_Java.JavaOOPExams.bank.repositories;

import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.loan.Loan;

public interface Repository {

    void addLoan(Loan loan);

    boolean removeLoan(Loan loan);

    Loan findFirst(String type);
}
