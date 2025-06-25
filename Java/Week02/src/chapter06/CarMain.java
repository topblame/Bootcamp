package chapter06;

public class CarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car_04 car = new Car_04();
		
		System.out.println("제작회사: " +car.company);
		System.out.println("모델명 " + car.model);
		System.out.println("색 " + car.color);
		System.out.println("최고속도 : " + car.maxSpeed);
		System.out.println("현재속도 " + car.speed);
		car.speed = 60;
		System.out.println("변경된 현재속도: " + car.speed );
	}

}
