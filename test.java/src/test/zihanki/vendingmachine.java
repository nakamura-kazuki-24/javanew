package test.zihanki;

import java.util.ArrayList;
import java.util.List;

public class vendingmachine {
    private List<product> products;
    private money money;

    public vendingmachine() {
        products = new ArrayList<>();
        money = new money();

        // 商品を追加（要件に従って 5 種類以上、110/120/130円含む）
        products.add(new product("お茶", 110));
        products.add(new product("コーヒー", 120));
        products.add(new product("水", 100));
        products.add(new product("ジュース", 130));
        products.add(new product("スポーツドリンク", 150));
    }

    public void showProducts() {
        System.out.println("=== 商品一覧 ===");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ": " + products.get(i));
        }
    }

    public boolean insertMoney(int amount) {
        boolean success = money.insert(amount);
        if (success) {
            System.out.println("投入額: " + money.getBalance() + "円");
        } else {
            System.out.println("この金額は使えないか、上限を超えています。");
        }
        return success;
    }

    public void buyProduct(int index) {
        if (index < 1 || index > products.size()) {
            System.out.println("無効な商品番号です。");
            return;
        }

        product product = products.get(index - 1);
        if (money.canAfford(product.getPrice())) {
            money.deduct(product.getPrice());
            System.out.println(product.getName() + " を購入しました。");
        } else {
            System.out.println("残高不足です。");
        }
        System.out.println("現在の残高: " + money.getBalance() + "円");
    }

    public void refund() {
        int refundAmount = money.refund();
        System.out.println("返金額: " + refundAmount + "円");
    }
}
