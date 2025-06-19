package test.zihanki;

// 必要なライブラリのインポート
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class zihanki_henkou {
    public static void main(String[] args) {
        // データベース初期化（テーブル作成や初期データ挿入）
        zihanki_DB.main(null);

        // ユーザーからの入力を受け取るためのスキャナ
        Scanner scanner = new Scanner(System.in);

        // データベース接続情報（MySQL）
        String jdbcURL = "jdbc:mysql://localhost:3306/zihanki"; // データベースのURL
        String user = "root";      // ユーザー名
        String password = "";      // パスワード（未設定）

        // try-with-resources で自動的に接続とStatementをクローズする
        try (
            Connection conn = DriverManager.getConnection(jdbcURL, user, password); // DBへ接続
            Statement stmt = conn.createStatement();                                 // SQL実行オブジェクト
        ) {
            boolean running = true;

            // メニューを繰り返し表示
            while (running) {
                // メニュー表示
                System.out.println("\n==== 自販機データ編集メニュー ====");
                System.out.println("1. 商品を追加する");
                System.out.println("2. 商品を削除する");
                System.out.println("3. 商品の価格を変更する");
                System.out.println("4. 在庫を追加する");
                System.out.println("5. 終了する");
                System.out.print("番号を選んでください: ");

                // 入力されたメニュー番号を取得
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1: // 商品を追加
                        System.out.print("商品名: ");
                        String name = scanner.nextLine();

                        System.out.print("値段: ");
                        int price = Integer.parseInt(scanner.nextLine());

                        System.out.print("在庫数: ");
                        int stock = Integer.parseInt(scanner.nextLine());

                        // SQL文を組み立ててINSERT実行
                        String insertSQL = "INSERT INTO data(syouhinmei, nedan, zaiko) VALUES('" +
                                            name + "', " + price + ", " + stock + ");";
                        stmt.executeUpdate(insertSQL);
                        System.out.println(name + " を追加しました");
                        break;

                    case 2: // 商品を削除
                        System.out.print("削除する商品名: ");
                        String deleteName = scanner.nextLine();

                        String deleteSQL = "DELETE FROM data WHERE syouhinmei = '" + deleteName + "';";
                        int deleted = stmt.executeUpdate(deleteSQL);
                        if (deleted > 0) {
                            System.out.println(deleteName + " を削除しました");
                        } else {
                            System.out.println("商品が見つかりませんでした");
                        }
                        break;

                    case 3: // 商品の価格変更
                        System.out.print("価格を変更する商品名: ");
                        String updateName = scanner.nextLine();

                        System.out.print("新しい価格: ");
                        int newPrice = Integer.parseInt(scanner.nextLine());

                        String updateSQL = "UPDATE data SET nedan = " + newPrice +
                                           " WHERE syouhinmei = '" + updateName + "';";
                        int updated = stmt.executeUpdate(updateSQL);
                        if (updated > 0) {
                            System.out.println(updateName + " の価格を " + newPrice + "円 に変更しました");
                        } else {
                            System.out.println("商品が見つかりませんでした");
                        }
                        break;

                    case 4: // 在庫を追加
                        System.out.print("在庫を追加する商品名: ");
                        String stockName = scanner.nextLine();

                        System.out.print("追加する在庫数: ");
                        int addStock = Integer.parseInt(scanner.nextLine());

                        String stockSQL = "UPDATE data SET zaiko = zaiko + " + addStock +
                                          " WHERE syouhinmei = '" + stockName + "';";
                        int stockResult = stmt.executeUpdate(stockSQL);
                        if (stockResult > 0) {
                            System.out.println(stockName + " の在庫に " + addStock + " 個追加しました");
                        } else {
                            System.out.println("商品が見つかりませんでした");
                        }
                        break;

                    case 5: // 終了
                        System.out.println("終了します");
                        running = false;
                        break;

                    default: // それ以外の番号はエラー
                        System.out.println("無効な選択です。1〜5を入力してください。");
                }
            }
        } catch (SQLException e) {
            // SQLエラーが発生した場合のメッセージ表示
            System.out.println("データベースエラーが発生しました");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // 数字が入力されなかった場合のエラー処理
            System.out.println("数字を正しく入力してください");
        }

        // スキャナを閉じてリソース解放
        scanner.close();
    }
}
