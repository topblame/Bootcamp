package chapter07;

public class Company_05 {
	//객체 단 하나만 생성하는 클래스 singleton
	private static Company_05 instance = new Company_05();
	
	public Company_05() {
		
	}
	public static Company_05 getInstance() {
		// 예외처리  - > 생성될 객체가 없으면 객체 생성.
		if(instance == null) {
			instance = new Company_05();
		}
		return instance;
	}
}
