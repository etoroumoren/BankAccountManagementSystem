package base;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

abstract public class BankAccount implements Printable, Transactable {

    private int accountNumber;
    private BigDecimal balance;
    private String owner;
    private AccountStatus status = AccountStatus.ACTIVE;
    private final List<Transaction> transactions = new ArrayList<>();

    public BankAccount (int accountNumber, BigDecimal balance, String owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    public class Transaction {
        private final BigDecimal amount;
        private final TransactionType type;
        private final LocalDateTime timestamp;

        public Transaction (BigDecimal amount, TransactionType type) {
            this.amount = amount;
            this.type = type;
            this.timestamp = LocalDateTime.now();
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public LocalDateTime getNow() {
            return timestamp;
        }

        @Override
        public String toString() {
            return timestamp + ": " + type + ": " + amount;
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    abstract public String getAccountType();

    public boolean deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) return false;
        if(status != AccountStatus.ACTIVE) return false;
        this.balance = this.balance.add(amount);
        transactions.add(new Transaction(amount, TransactionType.DEPOSIT));
        return true;
    }

    public boolean withdraw(BigDecimal amount) {
        if(status != AccountStatus.ACTIVE) return false;
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) return false;
        if(balance.compareTo(amount) < 0) return false;
        this.balance = this.balance.subtract(amount);
        transactions.add(new Transaction(amount, TransactionType.WITHDRAWAL));
        return true;
    }

    public void printStatement() {

        for(Transaction transaction: transactions) {
            System.out.println(transaction);
        }
    }


    public boolean transfer(BankAccount target, BigDecimal amount) {
        if (target == null || target == this) return false;
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) return false;

        if (getStatus() != AccountStatus.ACTIVE || target.getStatus() != AccountStatus.ACTIVE) return false;

        if (!this.withdraw(amount)) return false;
        if (!target.deposit(amount)) {
            this.deposit(amount); // rollback
            return false;
        }
        return true;
    }

}
