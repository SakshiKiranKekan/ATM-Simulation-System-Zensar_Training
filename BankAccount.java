public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private String pin;
    private double balance;
    
    // Constructor
    public BankAccount(String accountNumber, String accountHolder, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = balance;
    }
    
    // Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public String getPin() { return pin; }
    public double getBalance() { return balance; }
    
    public void setBalance(double balance) { this.balance = balance; }
    
    // Deposit method
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }
    
    // Withdraw method
    public boolean withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + 
               "\nAccount Holder: " + accountHolder + 
               "\nBalance: " + balance;
    }
}
