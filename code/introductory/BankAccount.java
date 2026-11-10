package week2;

class BankAccount {
    // Attributes (Instance Variables)
    private String accountHolder;
    private double balance;

    // Constructor: Initializes a new account object
    BankAccount(String name, double initialBalance) {
        this.accountHolder = name;
        this.balance = initialBalance;
    }

    // Method to deposit money
    void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited $" + amount);
    }

    // Method to display balance details
    void displayDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: $" + balance);
        System.out.println("---------------------------");
    }
}
