package test.java;

import javax.smartcardio.Card;

public class kadai3_sisutemu {
    private String name;
    private Card card;
    private Account account;

    public kadai3_sisutemu(String name, Card card, Account account) {
        this.name = name;
        this.card = card;
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public Account getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }
}
