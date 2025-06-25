package chapter09;

public class CarMain_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		method(new AICar());
//		System.out.println();
//		method(new ManualCar());
		
		System.out.println("------------자율 주행 --------------");
		Car mycar = new AICar();
		mycar.run();
		System.out.println("------------직접 주행 --------------");
		Car hiscar = new ManualCar();
		hiscar.run();
	}
	public static void method(Car Car) {
		Car.drive();
		Car.stop();
	}
}
