package base;

import java.math.BigDecimal;

public interface Transactable {

    public boolean transfer(BankAccount target, BigDecimal amount);
}
