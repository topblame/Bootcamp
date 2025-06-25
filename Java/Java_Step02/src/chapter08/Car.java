package chapter08;

public class Car {
	public int speed;
	
	public void speedUp() {
		speed += 1;
	}
	// override가 불가능한 메서드
	public final void stop() {
		System.out.println("자동차가 멈춥니다.");
		speed = 0;
	}
}
