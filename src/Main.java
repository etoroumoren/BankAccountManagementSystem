import base.BankAccount;
import subclasses.CurrentAccount;
import subclasses.FixedDepositAccount;
import subclasses.SavingsAccount;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    List<BankAccount> accounts = new ArrayList<>();
    accounts.add(new SavingsAccount( 12345,
            new BigDecimal("500.00"),
            "Ikpa",
            new BigDecimal("5"),
            new BigDecimal("200")));
    accounts.add(new CurrentAccount(
            12345,
            new BigDecimal("500.00"),
            "Ikpa",
            new BigDecimal("300")
    ));
    accounts.add(new FixedDepositAccount(
            12345,
            new BigDecimal("500.00"),
            "Ikpa",
            LocalDate.now(),
            2
    ));

    for (BankAccount account : accounts) {
        System.out.println(account.getAccountType());
        account.withdraw(new BigDecimal("500")); // different behavior per type
        account.printStatement();
    }
}
