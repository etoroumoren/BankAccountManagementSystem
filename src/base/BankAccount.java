package base;

import java.time.LocalDate;
import java.time.LocalDateTime;

abstract public class BankAccount implements Printable, Transactable {

    private int accountNumber;
    private double balance;
    private String owner;
    private AccountStatus status = AccountStatus.ACTIVE;

    public BankAccount (int accountNumber, double balance, String owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    public class Transaction {
        private int amount;
        private LocalDateTime now;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public LocalDateTime getNow() {
            return now;
        }

        public void setNow(LocalDateTime now) {
            this.now = now;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    abstract public String getAccountType();

    public boolean deposit(int amount) {
        if(amount <= 0) return false;
        if(status != AccountStatus.ACTIVE) return false;
        this.balance += amount;
        return true;
    }

    public boolean withdraw(int amount) {
        if(status != AccountStatus.ACTIVE) return false;
        if(amount <= 0) return false;
        this.balance -= amount;
        return true;
    }

    public void printStatement() {
        System.out.println("Your account balance is: " + getBalance());
    }


    public boolean transfer(BankAccount target, int amount) {
        if(target == null || target == this) return false;
        if(getStatus() != AccountStatus.ACTIVE || target.getStatus() != AccountStatus.ACTIVE) return false;

        if(!this.withdraw(amount)) return false;
        if(!target.deposit(amount)) {
            this.deposit(amount);
            return false;
        }

        return true;
    }
}
