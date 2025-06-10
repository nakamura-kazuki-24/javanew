package test.java;
import java.util.Scanner;

class Player {
    String name;
    int[] scores;

    Player(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
    }

    int scoreDiff(int[] par) {
        return scores[0] - par[0]; // 1ホール目の差
    }
}

public class kadai2 {
    public static void main(String[] args) {
        int[] par = {4, 4, 3, 4, 5, 4, 5, 3, 4, 4, 3, 4, 5, 4, 3, 4, 5, 4}; // PAR情報

        Scanner scanf = new Scanner(System.in);
        String input;
        Player player1 = null;
        Player player2 = null;

        while (true) {
            System.out.print("Input > ");
            input = scanf.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("入力が空です。再入力してください。");
                continue;
            }

            input = input.replaceAll("\\s+", ""); // 空白除去
            String[] parts = input.split(",");

            if (parts.length != 38) {
                System.out.println("入力形式エラー：名前2つ＋スコア36個をカンマで区切って入力してください。");
                continue;
            }

            try {
                String name1 = parts[0];
                String name2 = parts[1];

                int[] scores1 = new int[18];
                int[] scores2 = new int[18];

                for (int i = 0; i < 18; i++) {
                    scores1[i] = Integer.parseInt(parts[i + 2]);
                    if (scores1[i] <= 0) throw new IllegalArgumentException("スコアに0以下が含まれています。");
                }

                for (int i = 0; i < 18; i++) {
                    scores2[i] = Integer.parseInt(parts[i + 20]);
                    if (scores2[i] <= 0) throw new IllegalArgumentException("スコアに0以下が含まれています。");
                }

                player1 = new Player(name1, scores1);
                player2 = new Player(name2, scores2);
                break;

            } catch (NumberFormatException e) {
                System.out.println("スコアに数値以外が含まれています。");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("git嫌い");

        scanf.close();

        int diff1 = player1.scoreDiff(par);
        int diff2 = player2.scoreDiff(par);

        System.out.printf("%s: 1ホール終了して、%+d です。\n", player1.name, diff1);
        System.out.printf("%s: 1ホール終了して、%+d です。\n", player2.name, diff2);

        if (diff1 < diff2) {
            System.out.printf("勝者: %s\n", player1.name);
        } else if (diff2 < diff1) {
            System.out.printf("勝者: %s\n", player2.name);
        } else {
            System.out.println("引き分けです！");
        }
    }
}
