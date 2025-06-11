package test.java;
import java.util.Scanner;

public class kadai1 {
    public static void main(String[] args) {
        int[] horu = {4, 4, 3, 4, 5, 4, 5, 3, 4, 4, 3, 4, 5, 4, 3, 4, 5, 4}; // par情報（18ホール）
        Scanner scanf = new Scanner(System.in);
        String nyuuryoku;
        int[] scores = null; // 入力に合わせて後でサイズ決定

        while (true) {
            System.out.print("Input >");
            nyuuryoku = scanf.nextLine();

            // 空入力チェック
            if (nyuuryoku.trim().isEmpty()) {
                System.out.println("何も入力されていません。再入力してください。");
                continue;
            }

            // 数字、カンマ、空白以外の文字が含まれていたらやり直し
            if (!nyuuryoku.matches("[0-9,\\s]+")) {
                System.out.println("数値と,と半角空白以外が入力されています。再入力してください。");
                continue;
            }

            nyuuryoku = nyuuryoku.replaceAll("\\s+", ""); // 空白除去
            String[] kansei = nyuuryoku.split(",");

            // スコア用配列を入力数に合わせて作成
            scores = new int[kansei.length];
            
            boolean ok = true;
            
            for (int i = 0; i < kansei.length; i++) {
                scores[i] = Integer.parseInt(kansei[i]);
                if(scores[i] <= 0) {
                	System.out.println("入力された数値が０以下です。再度入力してください。");
                	ok = false;
                	continue;
                }
            }
            if (ok == true) {
            	break;
            }
        }
        scanf.close();

        // horu.length(18ホール) と scores.length の小さい方まで表示
        int len = Math.min(horu.length, scores.length);
        int totalScore = 0;
        for (int i = 0; i < len; i++) {
        	totalScore += scores[i] - horu[i];
        }

        System.out.printf("Output > %dホール終了して、%d です。\n", len, totalScore);

    }
}
