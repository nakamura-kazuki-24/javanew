package test.java;
 
import java.util.Scanner;  // Scannerクラスをインポート　Cのscanfをできるようにする

import mondai.test_method;
 
 
public class testeba {
	public static void main(String[] args) {
		Scanner scanf = new Scanner(System.in);//新しく文字列を入力
		test_method me = new test_method();
		String str;														//文字列宣言
		int num;
		System.out.print("よろしく\n");
		System.out.print("文字を入力してください：");
		str = scanf.nextLine();
		System.out.println("ーaーーーー " + str + " ーーーーー");
		System.out.print("数値を入力して下さい");
		String str_i = scanf.nextLine();
		int i = Integer.parseInt(str_i);
		System.out.print("数値を入力して下さい");
		String str_j = scanf.nextLine();								//next1で１文字nextlineで文字列
		int j = Integer.parseInt(str_j);
		System.out.print("足し算した結果:"+me.tasu(i, j) + "\n");
		System.out.print("引き算した結果:" + me.hiku(i, j)  + "\n");

		System.out.print("掛け算した結果:" + me.kakeru(i, j) + "\n");
		me.getDayTime();
		for(int o = 1 ; o <= 9 ; o++) {
			for(int p = 1 ; p <= 9 ; p++) {
				System.out.println(o * p );
			}
		}
	}
}