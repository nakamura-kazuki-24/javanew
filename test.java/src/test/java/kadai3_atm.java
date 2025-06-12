package test.java;

// ATM専用のカスタム例外クラス
class ATMException extends Exception {
    public ATMException(String message) {
        super(message); // 親クラスExceptionのコンストラクタにメッセージを渡す
    }
}

// キャッシュカードを表すクラス
class Card {
    private String cardNumber; // カード番号
    private String pin;        // 暗証番号

    // コンストラクタ：カード番号と暗証番号を初期化
    public Card(String cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    // 入力された暗証番号が正しいかチェックするメソッド
    public boolean authenticate(String inputPin) {
        return this.pin.equals(inputPin);
    }

    // カード番号を取得
    public String getCardNumber() {
        return cardNumber;
    }
}

// 銀行口座を表すクラス
class Account {
    private double balance; // 残高

    // コンストラクタ：初期残高を設定
    public Account(double balance) {
        this.balance = balance;
    }

    // 預け入れ処理：残高に金額を加算
    public void deposit(double amount) {
        balance += amount;
    }

    // 引き出し処理：残高が不足していれば例外を投げる
    public void withdraw(double amount) throws ATMException {
        if (amount > balance) {
            throw new ATMException("残高不足です。"); // 残高不足ならエラー
        }
        balance -= amount;
    }

    // 現在の残高を取得
    public double getBalance() {
        return balance;
    }
}

// 入出金のトランザクションを処理するクラス
class Transaction {
    // 預け入れ処理：口座に金額を追加し、結果を出力
    public static void deposit(Account account, double amount) {
        account.deposit(amount);
        System.out.println("預け入れ完了: " + (int)amount + "円");
        System.out.println("現在の残高: " + (int)account.getBalance() + "円");
    }

    // 引き出し処理：口座から金額を引き、結果を出力（例外に注意）
    public static void withdraw(Account account, double amount) throws ATMException {
        account.withdraw(amount);
        System.out.println("引き出し完了: " + (int)amount + "円");
        System.out.println("現在の残高: " + (int)account.getBalance() + "円");
    }
}
