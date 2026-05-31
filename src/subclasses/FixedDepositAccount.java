package subclasses;

import base.BankAccount;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class FixedDepositAccount extends BankAccount {

    private final LocalDate startDate;
    private final Period lockPeriod;

    public FixedDepositAccount(int accountNumber, BigDecimal balance, String owner, LocalDate startDate, int lockYears){
        super(accountNumber, balance, owner);
        this.startDate = startDate;
        this.lockPeriod = Period.ofYears(lockYears);
    }

    @Override
    public String getAccountType() {
        return "Fixed deposit account";
    }

    public LocalDate getMaturityDate(){
        return startDate.plus(lockPeriod);
    }

    public boolean isLocked() {
        return LocalDate.now().isBefore(getMaturityDate());
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) return false;

        if (isLocked()) {
            return false;
        }
        return super.withdraw(amount);
    }
}
