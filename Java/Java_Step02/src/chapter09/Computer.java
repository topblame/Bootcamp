package chapter09;

//단 하나라도 추상 메서드가 존재하면 추상 클래스가 됨.
public abstract class Computer {
	//추상메소드 -> 바디가 없다.
	public abstract void display() ; // 하위클래스에서 구현하여 사용하세요.
	
	public abstract void typing() ; // 하위클래스에서 구현하여 사용하세요.
	
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
}
