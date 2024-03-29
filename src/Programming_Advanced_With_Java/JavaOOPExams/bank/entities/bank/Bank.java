package Programming_Advanced_With_Java.JavaOOPExams.bank.entities.bank;

import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.client.Client;
import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.loan.Loan;

import java.util.Collection;

public interface Bank {
    String getName();

    void setName(String name);

    Collection<Client> getClients();

    Collection<Loan> getLoans();

    void addClient(Client client);

    void removeClient(Client client);

    void addLoan(Loan loan);

    int sumOfInterestRates();

    String getStatistics();
}
