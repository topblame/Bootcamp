package chapter06;

public class StdInfo {
	public String studentName;
	public int grade;
	public int money;
	
	public StdInfo() {
		// TODO Auto-generated constructor stub
	}
	public StdInfo(String studentName, int money){
		this.studentName= studentName;
		this.money = money;
	}
	
	//버스
	public void takeBus(Bus bus) {
		bus.take(1400); // 버스 회사 
		this.money -= 1400;
	}
	public void takeSubway(Subway subway) {
		subway.take(1800);
		this.money -= 1800;
	}
	public void showInfo() {
		System.out.println(studentName + "님의 남은 잔액은 "+ money + "원 입니다.");
	}
}
