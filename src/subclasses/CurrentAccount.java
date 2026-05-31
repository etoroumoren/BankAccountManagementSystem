package subclasses;

import base.BankAccount;

import java.math.BigDecimal;

public class CurrentAccount extends BankAccount {

    private BigDecimal overdraftLimit;

    public CurrentAccount(int accountNumber, BigDecimal balance, String owner, BigDecimal overdraftLimit) {
        super(accountNumber, balance, owner);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String getAccountType() {
        return "Current account";
    }

    public BigDecimal getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(BigDecimal overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(BigDecimal amount){
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) return false;

        BigDecimal minBalance = overdraftLimit.negate();

        BigDecimal newBalance = getBalance().subtract(amount);
        if(newBalance.compareTo(minBalance) < 0) return false;
        return super.withdraw(amount);
    }
}
