package test.java;

import java.util.Scanner;

import javax.smartcardio.Card;

public class kadai3_main {
    private kadai3_sisutemu currentUser;
    private Scanner scanner = new Scanner(System.in);

    public kadai3_main(kadai3_sisutemu user) {
        this.currentUser = user;
    }

    public void start() {
        System.out.println("取引を選択してください: 1: 預け入れ | 2: 引き出し");
        System.out.print("選択: ");
        String choice = scanner.nextLine();

        if (!choice.equals("1") && !choice.equals("2")) {
            System.out.println("無効な選択です。終了します。");
            return;
        }

        System.out.println("キャッシュカードを入れてください。");
        if (!authenticate()) {
            System.out.println("認証に失敗しました。カードを返却します。");
            return;
        }

        try {
            switch (choice) {
                case "1":
                    System.out.print("預け入れ金額: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    Transaction.deposit(currentUser.getAccount(), depositAmount);
                    break;

                case "2":
                    while (true) {
                        try {
                            System.out.print("引き出し金額: ");
                            double withdrawAmount = Double.parseDouble(scanner.nextLine());
                            Transaction.withdraw(currentUser.getAccount(), withdrawAmount);
                            break;
                        } catch (ATMException e) {
                            System.out.println("エラー: " + e.getMessage());
                            System.out.println("再度引き出し金額を入力してください。");
                        } catch (NumberFormatException e) {
                            System.out.println("金額の入力が正しくありません。再度入力してください。");
                        }
                    }
                    break;
            }
            System.out.println("カードを返却します。現金をお取りください。");

        } catch (NumberFormatException e) {
            System.out.println("金額の入力が正しくありません。終了します。");
        }
    }

    private boolean authenticate() {
        System.out.print("暗証番号を入力してください: ");
        String inputPin = scanner.nextLine();
        return currentUser.getCard().authenticate(inputPin);
    }

    public static void main(String[] args) {
        Card card = new Card("1234-5678", "0000");
        Account account = new Account(50000);
        kadai3_sisutemu user = new kadai3_sisutemu("太郎", card, account);

        kadai3_main atm = new kadai3_main(user);
        atm.start();
    }
}
