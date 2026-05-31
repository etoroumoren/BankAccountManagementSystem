package subclasses;

import base.BankAccount;

public class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    public CurrentAccount(int accountNumber, double balance, String owner, double overdraftLimit) {
        super(accountNumber, balance, owner);
        this.overdraftLimit = overdraftLimit;
    }

    public String getAccountType() {
        return "Current account";
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(int amount){
        if (amount <= 0) return false;

        if(getBalance() - amount < -overdraftLimit) {
            return false;
        }
        super.withdraw(amount);
        return true;
    }
}
