package test.zihanki;

public class money {
    private int balance = 0;
    private final int MAX_AMOUNT = 1990;

    public boolean insert(int amount) {
        if (isValidDenomination(amount) && balance + amount <= MAX_AMOUNT) {
            balance += amount;
            return true;
        }
        return false;
    }

    private boolean isValidDenomination(int amount) {
        return amount == 10 || amount == 50 || amount == 100 || amount == 500 || amount == 1000;
    }

    public boolean canAfford(int price) {
        return balance >= price;
    }

    public void deduct(int price) {
        balance -= price;
    }

    public int refund() {
        int refund = balance;
        balance = 0;
        return refund;
    }

    public int getBalance() {
        return balance;
    }
}
