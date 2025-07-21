import java.util.Scanner;

// Step 4: BankAccount class
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    // Withdraw method with validation
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    // Deposit method
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }
}

// Step 1 & 5: ATM class connects with BankAccount
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    // Step 3: Withdraw method
    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("✅ Withdrawal successful. Remaining Balance: ₹" + account.getBalance());
        } else {
            System.out.println("❌ Withdrawal failed. Insufficient balance or invalid amount.");
        }
    }

    // Step 3: Deposit method
    public void deposit(double amount) {
        if (account.deposit(amount)) {
            System.out.println("✅ Deposit successful. New Balance: ₹" + account.getBalance());
        } else {
            System.out.println("❌ Deposit failed. Invalid amount.");
        }
    }

    // Step 3: Check balance method
    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + account.getBalance());
    }
}

// Step 2, 6 & 7: User Interface
public class AtmInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 4: Create a bank account with initial balance
        BankAccount userAccount = new BankAccount(10000); // ₹10,000 initial balance

        // Step 5: Connect ATM to user's bank account
        ATM atm = new ATM(userAccount);

        // Looping menu system
        while (true) {
            System.out.println("\n=== 🏧 Welcome to Java ATM ===");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("❗ Invalid choice. Please select between 1-4.");
            }
        }
    }
}

