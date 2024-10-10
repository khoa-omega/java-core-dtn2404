package encapsulation;

public class Atm {
    private int balance;

    public Atm(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance > 0) {
            this.balance = balance;
        }
    }

    @Override
    public String toString() {
        return "Atm{" +
                "balance=" + balance +
                '}';
    }
}
