package rensyuuukurasu; //子 (サブクラス)

public class keisyou_ko extends keisyou_oya{
	void run() {
		System.out.println(name+"が走っている");
	}
	@Override
	void eat() {
		super.eat();
		System.out.println(name+"が走っている");
	}
	
}