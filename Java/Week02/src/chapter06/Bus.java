package chapter06;

public class Bus {
	int busNumber;
	int passengerCount;
	int money;
	

	public Bus() {
		// TODO Auto-generated constructor stub
	}
	
	// 생성자 오버로딩
	public Bus(int busNumber) {
		// TODO Auto-generated constructor stub
		this.busNumber = busNumber;
	}
	public void take(int money) { // 승객이 낸돈
		this.money += money; //버스 수입
		passengerCount++;// 승객의 수 증가
	}
	
	public void showInfo() {
		System.out.println(busNumber + "번 버스의 승객은 " + passengerCount+ "명이고 수입은 " + money + "원 입니다.");
		
	}
}
