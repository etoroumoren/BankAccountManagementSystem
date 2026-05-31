package subclasses;

import base.BankAccount;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {

    private BigDecimal interestRate;
    private BigDecimal withdrawalLimits;

    public SavingsAccount(int accountNumber, BigDecimal balance, String owner, BigDecimal interestRate, BigDecimal withdrawalLimits) {
        super(accountNumber, balance, owner);
        this.interestRate = interestRate;
        this.withdrawalLimits = withdrawalLimits;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getWithdrawalLimits() {
        return withdrawalLimits;
    }

    public void setWithdrawalLimits(BigDecimal withdrawalLimits) {
        this.withdrawalLimits = withdrawalLimits;
    }

    @Override
    public String getAccountType() {
        return "Savings account";
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) return false;

        BigDecimal minBalance = new BigDecimal("150");
        BigDecimal newBalance = getBalance().subtract(amount);

        if(newBalance.compareTo(minBalance) < 0) {
            return false;
        }

        return super.withdraw(amount);
    }
}
