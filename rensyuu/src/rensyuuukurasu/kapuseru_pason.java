/**
 * 
 */
package rensyuuukurasu;

/**
 * @author Administrator
 *
 */
public class kapuseru_pason {
	private String name;	//privateは外部からのアクセスを制限
	private int age;
	public String getName() {
		System.out.println("名前"+name);
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}		
	
	
	
}
