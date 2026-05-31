**Bank Account Management System**
A console-based banking simulation built in Java, demonstrating every core OOP pillar — inheritance, polymorphism, encapsulation, and abstraction 

**OOP Concepts Demonstrated**
Inheritance - SavingsAccount, CurrentAccount, FixedDepositAccount all extend BankAccount
Polymorphism - List<BankAccount> holds all three; withdraw() - behaves differently per type
Encapsulation - All fields private; accessed through validated getters/setters
Abstractionabstract getAccountType() forces all subclasses to identify themselves; interfaces define contracts
Interface - Printable (printStatement), Transactable (transfer)
Enum - AccountStatus (ACTIVE, FROZEN, CLOSED), TransactionType (DEPOSIT, WITHDRAWAL, TRANSFER)
Inner Class- Transaction nested inside BankAccount, storing amount, type, and timestamp


**Account Types**
SavingsAccount

Enforces a minimum balance threshold — withdrawals that would breach it are rejected
Carries an interest rate field

CurrentAccount

Supports overdraft up to a configured limit
Withdrawal succeeds even if balance goes negative, as long as it stays within the overdraft boundary

FixedDepositAccount
Locked until a maturity date computed from startDate + lockPeriod
All withdrawal attempts during the lock period are rejected regardless of balance
Deposits remain unaffected by the lock

**Tech Stack**
Language: Java 17+
Build tool: None required (compile with javac) or use any IDE
Dependencies: None (pure Java standard library)


**Running the project**
# Compile
javac -d out src/base/*.java src/subclasses/*.java src/Main.java

# Run
java -cp out Main






