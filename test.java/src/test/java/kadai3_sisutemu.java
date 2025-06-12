//データベースを使うかもしれないのでそれぞれのユーザーの認証
//今回の課題３には使う必要があるやつもあるがあまり必要ない


package test.java;

public class kadai3_sisutemu {
    private String name;       // ユーザーの名前
    private Card card;         // 所有しているキャッシュカード
    private Account account;   // 関連づけられた銀行口座

    // コンストラクタ：ユーザー情報（名前・カード・口座）を初期化
    public kadai3_sisutemu(String name, Card card, Account account) {
        this.name = name;
        this.card = card;
        this.account = account;
    }

    // カード情報を取得
    public Card getCard() {
        return card;
    }

    // 口座情報を取得
    public Account getAccount() {
        return account;
    }

    // ユーザーの名前を取得
    public String getName() {
        return name;
    }
}
