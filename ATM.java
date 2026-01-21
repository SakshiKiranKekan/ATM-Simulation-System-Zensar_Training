public class ATM {
    public static void main(String[] args) {
        System.out.println("========== WELCOME TO ATM SYSTEM ==========");
        
        ATMMenu atmMenu = new ATMMenu();
        
        // Login attempt
        if (atmMenu.login()) {
            // Show main menu if login successful
            atmMenu.showMainMenu();
        } else {
            System.out.println("Login failed. Exiting...");
        }
        
        atmMenu.close();
        System.out.println("\nThank you for using our ATM System!");
    }
}
