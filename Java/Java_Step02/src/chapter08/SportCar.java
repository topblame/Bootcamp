package chapter08;

public class SportCar extends Car{
	
	@Override
	public void speedUp() {
		speed += 10;
		System.out.println("speed  : "  + speed);
	}

	//final 메서드 이므로 재정의 불가

	public static void main(String[] args) {
		SportCar sc = new SportCar()	;
		sc.speedUp();
		sc.stop();
	}
}
