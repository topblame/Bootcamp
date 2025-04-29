package chapter06;

public class AccessTest {

	//멤버변수 = 필드
	private int aa; // 접근지정자로 현재 클래스에서만 사용가능
	public int bb; //접근지정자 공용
	int cc;
	// 생성자 생략
	
	//메서드 
	public void setAa(int aa) {
		this.aa = aa;
	}

	public void setBb(int bb) {
		this.bb = bb;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
	public void Disp() {
		System.out.println("aa값: " + aa + " bb값: " + bb + " cc값: " + cc );
	}
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		
		obj.aa = 10;
		//System.out.println("aa = 10 - > " + obj.aa);
		obj.setAa(20);
		System.out.println("set aa = 20 - > " + obj.aa);
		obj.setBb(30);
		System.out.println("set bb = 30 - > " + obj.bb);
		obj.setCc(40);
		System.out.println("set cc = 40 - > " + obj.cc);
	}
}
