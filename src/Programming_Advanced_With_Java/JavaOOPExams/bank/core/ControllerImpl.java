package Programming_Advanced_With_Java.JavaOOPExams.bank.core;

import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.bank.Bank;
import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.bank.BranchBank;
import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.bank.CentralBank;
import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.client.Adult;
import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.client.Client;
import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.client.Student;
import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.loan.Loan;
import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.loan.MortgageLoan;
import Programming_Advanced_With_Java.JavaOOPExams.bank.entities.loan.StudentLoan;
import Programming_Advanced_With_Java.JavaOOPExams.bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;

import static Programming_Advanced_With_Java.JavaOOPExams.bank.common.ConstantMessages.*;
import static Programming_Advanced_With_Java.JavaOOPExams.bank.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private LoanRepository loanRepository;
    private Collection<Bank> banks;

    public ControllerImpl() {
        this.loanRepository = new LoanRepository();
        this.banks = new ArrayList<>();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank;
        switch (type) {
            case "BranchBank":
                bank = new BranchBank(name);
                break;
            case "CentralBank":
                bank = new CentralBank(name);
                break;
            default:
                throw new NullPointerException(INVALID_BANK_TYPE);
        }

        this.banks.add(bank);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan;
        switch (type) {
            case "MortgageLoan":
                loan = new MortgageLoan();
                break;
            case "StudentLoan":
                loan = new StudentLoan();
                break;
            default:
                throw new IllegalArgumentException(INVALID_LOAN_TYPE);
        }

        this.loanRepository.addLoan(loan);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Bank bank = this.banks.stream().filter(b -> b.getName().equals(bankName)).findFirst().orElse(null);

        Loan loan = this.loanRepository.findFirst(loanType);
        if (loan == null) {
            throw new IllegalArgumentException(String.format(NO_LOAN_FOUND, loanType));
        }

        assert bank != null;
        bank.addLoan(loan);
        this.loanRepository.removeLoan(loan);
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Client client;
        switch (clientType) {
            case "Student":
                client = new Student(clientName, clientID, income);
                break;
            case "Adult":
                client = new Adult(clientName, clientID, income);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CLIENT_TYPE);
        }
        Bank bank = this.banks.stream().filter(b -> b.getName().equals(bankName)).findFirst().orElse(null);
        assert bank != null;
        if (bank.getClass().getSimpleName().equals("CentralBank") && clientType.equals("Student")){
            return UNSUITABLE_BANK;
        } else if (bank.getClass().getSimpleName().equals("BranchBank") && clientType.equals("Adult")) {
            return UNSUITABLE_BANK;
        }

        bank.addClient(client);
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
    }

    @Override
    public String finalCalculation(String bankName) {
        Bank bank = this.banks.stream().filter(b -> b.getName().equals(bankName)).findFirst().orElse(null);
        assert bank != null;
        Collection<Loan> loans = bank.getLoans();
        double loanSum = loans.stream().mapToDouble(Loan::getAmount).sum();
        Collection<Client> clients = bank.getClients();
        double clientsSum = clients.stream().mapToDouble(Client::getIncome).sum();

        return String.format(FUNDS_BANK, bankName, loanSum + clientsSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Bank bank : this.banks) {
            sb.append(bank.getStatistics());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
