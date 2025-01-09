package atmInterface;

import java.util.ArrayList;

class Account {
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount, balance));
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount, balance));
            return true;
        } else {
            return false;
        }
    }

    public boolean transfer(Account targetAccount, double amount) {
        if (amount <= balance) {
            balance -= amount;
            targetAccount.deposit(amount);
            transactionHistory.add(new Transaction("Transfer", amount, balance));
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}

