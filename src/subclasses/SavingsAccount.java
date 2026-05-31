package subclasses;

import base.BankAccount;

public class SavingsAccount extends BankAccount {

    private double interestRate;
    private double withdrawalLimits;

    public SavingsAccount(int accountNumber, double balance, String owner, double interestRate, double withdrawalLimits) {
        super(accountNumber, balance, owner);
        this.interestRate = interestRate;
        this.withdrawalLimits = withdrawalLimits;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getWithdrawalLimits() {
        return withdrawalLimits;
    }

    public void setWithdrawalLimits(double withdrawalLimits) {
        this.withdrawalLimits = withdrawalLimits;
    }

    @Override
    public String getAccountType() {
        return "Savings account";
    }

    @Override
    public boolean withdraw(int amount) {
        if(amount < 0) return false;
        if(getBalance() - amount < 150) {
            return false;
        }

        super.withdraw(amount);
        return true;
    }
}
