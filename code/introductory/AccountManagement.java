package week2;

public class AccountManagement{
    public static void main(String[] args) {
        // Creating the first object
        BankAccount account1 = new BankAccount("Saeed", 100.0);
        
        // Creating a second object
        BankAccount account2 = new BankAccount("Khaled", 250.0);

        // Interacting with the objects
        account1.displayDetails();
        account2.displayDetails();

        // Performing operations
        account1.deposit(50.0);
        
        // Display updated status
        account1.displayDetails();
    }
}
