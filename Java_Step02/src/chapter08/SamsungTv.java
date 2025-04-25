package chapter08;

public class SamsungTv extends Appliance{

	public SamsungTv(String brand) {
		super(brand);
	}

	@Override
	void turnOff() {
		// TODO Auto-generated method stub
		super.turnOff();
		System.out.println("TV를 끕니다.");
	}
	
}
