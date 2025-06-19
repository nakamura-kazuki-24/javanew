package test.zihanki;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        vendingmachine vm = new vendingmachine();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== 自動販売機シミュレータ ===");

        while (running) {
            System.out.println("\n1. お金を投入");
            System.out.println("2. 商品を購入");
            System.out.println("3. 残金を返却");
            System.out.println("4. 終了");
            System.out.print("選択してください: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("投入金額を入力（10, 50, 100, 500, 1000）: ");
                    int amount = scanner.nextInt();
                    vm.insertMoney(amount);
                    break;
                case 2:
                    vm.showProducts();
                    System.out.print("購入する商品の番号を入力: ");
                    int productIndex = scanner.nextInt();
                    vm.buyProduct(productIndex);
                    break;
                case 3:
                    vm.refund();
                    break;
                case 4:
                    vm.refund();
                    System.out.println("ご利用ありがとうございました。");
                    running = false;
                    break;
                default:
                    System.out.println("無効な選択です。");
            }
        }

        scanner.close();
    }
}
