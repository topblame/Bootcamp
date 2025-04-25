package chapter09;

public abstract class Car {
	public abstract void drive();
	public abstract void stop();
	
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	// 재정의가 안되게 구현
	public final void run() {
		startCar();
		drive();
		stop();
		turnOff();
	}
	
}
