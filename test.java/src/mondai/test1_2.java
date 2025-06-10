/**
 * 
 */
package mondai;

public class test1_2 {

	public static void main(String[] args) {
		class Animal {
		    void eat() {
		        System.out.println("I can eat");
		    }
		}

		class Dog extends Animal {
		    void bark() {
		        System.out.println("I can bark");
		    }
		}

		public class Main {
		    public static void main(String[] args) {
		        Dog d = new Dog();
		        d.eat();  // 親クラスのメソッド
		        d.bark(); // 子クラスのメソッド
		    }
		}

	}

}
