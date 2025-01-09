package atmInterface;

import java.util.ArrayList;
import java.util.Scanner;

class ATMService {
    private User currentUser;
    private Scanner scanner;

    public ATMService() {
        scanner = new Scanner(System.in);
    }

    public void start(User user) {
        this.currentUser = user;
        System.out.println("Welcome to the ATM!");

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    handleWithdrawal();
                    break;
                case 3:
                    handleDeposit();
                    break;
                case 4:
                    handleTransfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.print("Choose an option: ");
    }

    private void showTransactionHistory() {
        ArrayList<Transaction> history = currentUser.getAccount().getTransactionHistory();
        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : history) {
                System.out.println(transaction);
            }
        }
    }

    private void handleWithdrawal() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        if (currentUser.getAccount().withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void handleDeposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        currentUser.getAccount().deposit(amount);
        System.out.println("Deposit successful.");
    }

    private void handleTransfer() {
        System.out.print("Enter the target account number: ");
        String targetAccountNumber = scanner.nextLine();
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        // Simulate finding the target account
        Account targetAccount = new Account(targetAccountNumber, 0); // Replace with actual account lookup
        if (currentUser.getAccount().transfer(targetAccount, amount)) {
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
