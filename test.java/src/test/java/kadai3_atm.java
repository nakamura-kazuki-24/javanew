package test.java;

class ATMException extends Exception {
    public ATMException(String message) {
        super(message);
    }
}

class Card {
    private String cardNumber;
    private String pin;

    public Card(String cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public boolean authenticate(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public String getCardNumber() {
        return cardNumber;
    }
}

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws ATMException {
        if (amount > balance) {
            throw new ATMException("残高不足です。");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

class Transaction {
    public static void deposit(Account account, double amount) {
        account.deposit(amount);
        System.out.println("預け入れ完了: " + (int)amount + "円");
        System.out.println("現在の残高: " + (int)account.getBalance() + "円");
    }

    public static void withdraw(Account account, double amount) throws ATMException {
        account.withdraw(amount);
        System.out.println("引き出し完了: " + (int)amount + "円");
        System.out.println("現在の残高: " + (int)account.getBalance() + "円");
    }
}
