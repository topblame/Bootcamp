package chapter09;

public class AICar extends Car{

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("자율주행차량");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("스스로 정지합니다.");
	}
	
}
