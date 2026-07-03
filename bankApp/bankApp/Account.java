package bankApp;

public class Account {
    private int balance;
    private final String pin;

    public Account(String pin) {
        this.pin = pin;
        this.balance = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    public boolean withdraw(int amount, String inputPin) {
        if (!pin.equals(inputPin)) {
            return false;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
    public int getBalance(String inputPin) {
        if (!pin.equals(inputPin)) {
            return -1;
        }
        return balance;
    }
}