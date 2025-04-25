package chapter09;

public class ManualCar extends Car {

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("운전을합니다. ");
		System.out.println("핸들을 조작합니다.");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("브레이크로 정지합니다.");
	}
	
}
