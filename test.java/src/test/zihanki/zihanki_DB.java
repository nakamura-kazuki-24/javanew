package test.zihanki;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class zihanki_DB {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/zihanki";
        String usersyouhinmei = "root";
        String password = "";
 
        try (
            Connection conn = DriverManager.getConnection(jdbcURL, usersyouhinmei, password);
            Statement stmt = conn.createStatement()
        ) {
            String SQL;
 
            /*
             * data
             */
            try {
                stmt.execute("DROP TABLE IF EXISTS data;");
            } catch (SQLException e) {
                System.out.println("data 削除エラー");
                e.printStackTrace();
            }
 
            /*
             * okane
             */
            try {
                stmt.execute("DROP TABLE IF EXISTS okane;");
            } catch (SQLException e) {
                System.out.println("okane 削除エラー");
                e.printStackTrace();
            }
 
            //テーブル作成とデータ挿入
 
            try {
                SQL = "CREATE TABLE data(" +
                      "id INT AUTO_INCREMENT PRIMARY KEY, " +
                      "syouhinmei VARCHAR(50) NOT NULL, " +
                      "nedan INT NOT NULL, " +
                      "zaiko INT NOT NULL);";
                stmt.execute(SQL);
 
                stmt.execute("INSERT INTO data(syouhinmei, nedan, zaiko) VALUES('コーラ', 160, 5);");
                stmt.execute("INSERT INTO data(syouhinmei, nedan, zaiko) VALUES('生茶', 130, 2);");
                stmt.execute("INSERT INTO data(syouhinmei, nedan, zaiko) VALUES('コーヒー', 150, 3);");
                stmt.execute("INSERT INTO data(syouhinmei, nedan, zaiko) VALUES('水', 110, 4);");
                stmt.execute("INSERT INTO data(syouhinmei, nedan, zaiko) VALUES('リアルゴールド', 160, 5);");
 
                System.out.println("data 作成完了");
            } catch (SQLException e) {
                System.out.println("data 作成エラー");
                e.printStackTrace();
            }
 
            try {
                SQL = "CREATE TABLE okane(" +
                      "okane_syurui INT PRIMARY KEY, " +
                      "zaiko INT NOT NULL);";
                stmt.execute(SQL);
 
                stmt.execute("INSERT INTO okane VALUES(10, 100);");
                stmt.execute("INSERT INTO okane VALUES(50, 100);");
                stmt.execute("INSERT INTO okane VALUES(100, 100);");
                stmt.execute("INSERT INTO okane VALUES(500, 0);");
                stmt.execute("INSERT INTO okane VALUES(1000, 0);");
 
                System.out.println("okane 作成完了");
            } catch (SQLException e) {
                System.out.println("okane 作成エラー");
                e.printStackTrace();
            }
 
        } catch (SQLException e) {
            System.out.println("DB接続エラー");
            e.printStackTrace();
        }
    }
}
//chcp 65001