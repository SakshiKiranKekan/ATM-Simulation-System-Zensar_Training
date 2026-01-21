import java.util.Scanner;

public class ATMMenu {
    private Scanner scanner;
    private BankAccount currentAccount;
    private DatabaseManager dbManager;
    
    public ATMMenu() {
        scanner = new Scanner(System.in);
        dbManager = new DatabaseManager();
    }
    
    // Main ATM operations menu
    public void showMainMenu() {
        while (true) {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    showAccountDetails();
                    break;
                case 5:
                    logout();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    private void checkBalance() {
        System.out.println("\nCurrent Balance: " + currentAccount.getBalance());
    }
    
    private void depositMoney() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        
        if (amount > 0) {
            currentAccount.deposit(amount);
            dbManager.updateBalance(currentAccount.getAccountNumber(), currentAccount.getBalance());
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount!");
        }
    }
    
    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        
        if (currentAccount.withdraw(amount)) {
            dbManager.updateBalance(currentAccount.getAccountNumber(), currentAccount.getBalance());
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
    
    private void showAccountDetails() {
        System.out.println("\n" + currentAccount.toString());
    }
    
    public boolean login() {
        System.out.println("\n========== ATM LOGIN ==========");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        
        currentAccount = dbManager.authenticateUser(accountNumber, pin);
        
        if (currentAccount != null) {
            System.out.println("\nLogin successful! Welcome " + currentAccount.getAccountHolder());
            return true;
        } else {
            System.out.println("\nInvalid account number or PIN!");
            return false;
        }
    }
    
    private void logout() {
        currentAccount = null;
        System.out.println("\nLogged out successfully!");
    }
    
    public void close() {
        scanner.close();
        dbManager.closeConnection();
    }
}
