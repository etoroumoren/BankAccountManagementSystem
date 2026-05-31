package base;

abstract public class BankAccount implements Printable {

    private int accountNumber;
    private double balance;
    private String owner;
    private AccountStatus status = AccountStatus.ACTIVE;

    public BankAccount (int accountNumber, double balance, String owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
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

    public void deposit(int amount) {
        if(amount <= 0) return;
        if(status != AccountStatus.ACTIVE) return;
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if(status != AccountStatus.ACTIVE) return;
        this.balance -= amount;
    }

    public void printStatement() {
        System.out.println("Your account balance is: " + getBalance());
    }
}
