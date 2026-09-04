public class Account {
    private int accountNum;
    private double balance;

    public Account(int accountNum, double balance) {
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount >0 ) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public int getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }
}
