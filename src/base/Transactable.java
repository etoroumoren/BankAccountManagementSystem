package base;

public interface Transactable {

    public boolean transfer(BankAccount target, int amount);
}
