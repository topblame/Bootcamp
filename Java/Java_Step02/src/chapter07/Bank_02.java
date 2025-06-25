package chapter07;

public class Bank_02 {
	private String point;//지점명
	private String tel;//전화번호
	static float interest; //은행이자.

	public Bank_02(String point, String tel) {
		this.point = point;
		this.tel = tel;
	}//Bank
	
	//결과 출력 메서드
	public void getBank() {
		System.out.println("지점: "+point + "\n" + "전화번호: " + tel + "\n" + "은행이자: " + interest);
	}
	
	
	
}
