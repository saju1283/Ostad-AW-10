// Base class BankAccount
class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into account " + accountNumber);
    }

    // Base implementation of withdraw method
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient funds in account " + accountNumber);
        }
    }

    public double getBalance() {
        return balance;
    }
}

// SavingsAccount class, subclass of BankAccount
class SavingsAccount extends BankAccount {
    private double withdrawalLimit;

    public SavingsAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    // Override withdraw method to impose withdrawal limit
    @Override
    public void withdraw(double amount) {
        if (amount <= balance && amount <= withdrawalLimit) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " from savings account " + accountNumber);
        } else if (amount > withdrawalLimit) {
            System.out.println("Withdrawal amount exceeds daily withdrawal limit for savings account " + accountNumber);
        } else {
            System.out.println("Insufficient funds in savings account " + accountNumber);
        }
    }
}

// CheckingAccount class, subclass of BankAccount
class CheckingAccount extends BankAccount {
    private double overdraftFee;

    public CheckingAccount(String accountNumber, double balance, double overdraftFee) {
        super(accountNumber, balance);
        this.overdraftFee = overdraftFee;
    }

    // Override withdraw method to impose overdraft fee
    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " from checking account " + accountNumber);
        } else {
            balance -= (amount + overdraftFee);
            System.out.println("Overdraft of $" + amount + " in checking account " + accountNumber +
                    " with overdraft fee of $" + overdraftFee + " applied");
        }
    }
}

// Main class to test the BankAccount system
public class Main {
    public static void main(String[] args) {
        // Create a SavingsAccount
        SavingsAccount savingsAccount = new SavingsAccount("SAV-001", 1000.0, 500.0);
        savingsAccount.deposit(200.0);
        savingsAccount.withdraw(100.0);  // Allowed withdrawal within limit
        savingsAccount.withdraw(700.0);  // Exceeds daily withdrawal limit

        System.out.println("Savings Account Balance: $" + savingsAccount.getBalance());

        // Create a CheckingAccount
        CheckingAccount checkingAccount = new CheckingAccount("CHK-001", 500.0, 25.0);
        checkingAccount.deposit(100.0);
        checkingAccount.withdraw(50.0);  // Allowed withdrawal within balance
        checkingAccount.withdraw(600.0); // Exceeds balance, applies overdraft fee

        System.out.println("Checking Account Balance: $" + checkingAccount.getBalance());
    }
}
