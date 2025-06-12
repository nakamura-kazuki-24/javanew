package test.java;

import java.util.Scanner;

public class kadai3_main {
    private kadai3_sisutemu currentUser; // 現在の利用者の情報（カードと口座）
    private Scanner scanner = new Scanner(System.in); // ユーザー入力用スキャナ

    // コンストラクタ：利用者情報を受け取り初期化
    public kadai3_main(kadai3_sisutemu user) {
        this.currentUser = user;
    }

    // ATMのメイン処理
    public void start() {
        // 取引内容を選択させる
        System.out.println("取引を選択してください: 1: 預け入れ | 2: 引き出し");
        System.out.print("選択: ");
        String choice = scanner.nextLine(); // 入力を文字列として取得

        // 入力が 1 または 2 以外だった場合は終了
        if (!choice.equals("1") && !choice.equals("2")) {
            System.out.println("無効な選択です。終了します。");
            return;
        }

        // カード挿入を促す
        System.out.println("キャッシュカードを入れてください。");

        // 認証に失敗した場合は終了
        if (!authenticate()) {
            System.out.println("認証に失敗しました。カードを返却します。");
            return;
        }

        // 認証成功後、現在の残高を表示
        System.out.println("現在の残高: " + (int) currentUser.getAccount().getBalance() + "円");

        try {
            // 取引内容に応じて処理を分岐
            switch (choice) {
                case "1": // 預け入れ処理
                    System.out.print("預け入れ金額: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine()); // 金額を取得
                    Transaction.deposit(currentUser.getAccount(), depositAmount); // 預け入れ処理
                    break;

                case "2": // 引き出し処理（例外対応あり）
                    while (true) {
                        try {
                            System.out.print("引き出し金額: ");
                            double withdrawAmount = Double.parseDouble(scanner.nextLine());
                            Transaction.withdraw(currentUser.getAccount(), withdrawAmount);
                            break; // 成功したらループを抜ける
                        } catch (ATMException e) {
                            // 引き出しエラー（残高不足など）
                            System.out.println("エラー: " + e.getMessage());
                            System.out.println("再度引き出し金額を入力してください。");
                        } catch (NumberFormatException e) {
                            // 数字以外が入力されたときの処理
                            System.out.println("金額の入力が正しくありません。再度入力してください。");
                        }
                    }
                    break;
            }

            // 取引終了時の案内
            System.out.println("カードを返却します。現金をお取りください。");

        } catch (NumberFormatException e) {
            // 入力ミス（数値変換できない等）で終了
            System.out.println("金額の入力が正しくありません。終了します。");
        }
    }

    // 暗証番号認証処理（合うまでループ）
    private boolean authenticate() {
        while (true) {
            System.out.print("暗証番号を入力してください: ");
            String inputPin = scanner.nextLine();

            // 認証成功
            if (currentUser.getCard().authenticate(inputPin)) {
                return true;
            } else {
                // 認証失敗
                System.out.println("暗証番号が間違っています。再度入力してください。");
            }
        }
    }

    // メインメソッド：サンプルユーザーで ATM 起動
    public static void main(String[] args) {
        Card card = new Card("1234-5678", "0000"); // カード番号・PINを設定
        Account account = new Account(50000); // 残高5万円で口座作成
        kadai3_sisutemu user = new kadai3_sisutemu("太郎", card, account); // ユーザー情報作成

        kadai3_main atm = new kadai3_main(user); // ATMにユーザーを渡して起動
        atm.start();
    }
}
