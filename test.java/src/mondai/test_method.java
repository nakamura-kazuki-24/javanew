package mondai;
 
import java.time.LocalDateTime;
 
 
public class test_method {

	public int num;


	public int kakeru(int x , int y) {

		int sum;

		sum =  x * y;

		return sum;

	}

	public int tasu(int x , int y) {

		int sum;

		sum = x + y;
 
		return sum;

	}

	public int hiku(int x , int y) {

		int sum ;

		sum = x - y;

		return sum;

	}

		public String getDayTime() {//日時の取得メソッド

		 LocalDateTime now = LocalDateTime.now();

	        System.out.println("現在の日時: " + now);

	        return "";

	}


 
}

 