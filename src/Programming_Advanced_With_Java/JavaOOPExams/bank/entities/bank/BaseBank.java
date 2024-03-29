package Programming_Advanced_With_Java.JavaOOPExams.bank.entities.bank;

import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.client.Client;
import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static Programming_Advanced_With_Java.JavaOOPExams.bank.common.ExceptionMessages.BANK_NAME_CANNOT_BE_NULL_OR_EMPTY;
import static Programming_Advanced_With_Java.JavaOOPExams.bank.common.ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_CLIENT;

public abstract class BaseBank implements Bank {
    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    public BaseBank(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Client> getClients() {
        return this.clients;
    }

    @Override
    public Collection<Loan> getLoans() {
        return this.loans;
    }

    @Override
    public void addClient(Client client) {
        if (this.capacity <= this.clients.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CLIENT);
        }
        this.clients.add(client);
    }

    @Override
    public void removeClient(Client client) {
        this.clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    @Override
    public int sumOfInterestRates() {
        return this.loans.stream().mapToInt(Loan::getInterestRate).sum();
    }

    @Override
    public String getStatistics() {
        List<String> clientsList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Type: %s%n", getName(), this.getClass().getSimpleName()));
        sb.append("Clients: ");
        if (this.clients.isEmpty()) {
            sb.append("none");
        } else {
            for (Client client : this.clients) {
                clientsList.add(client.getName());
            }
            String join = String.join(", ", clientsList);
            sb.append(join);
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("Loans: %d, Sum of interest rates: %d", this.loans.size(), sumOfInterestRates()));
        return sb.toString().trim();
    }
}
