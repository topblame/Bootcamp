package chapter10.Interface;

public interface Calc {
	double PI =3.14;
	int ERROR = -9999999;
	
	int add(int num1, int num2);
	
	int substaract(int num1, int num2);
	
	int times(int num1, int num2);
	
	int divide(int num1, int num2);
	
	//자바 8부터 제공->  기본 수행문을 구현할 때 사용 (재정의 가능)
	default void description() {
		System.out.println("정수 계산");
		myMethon(); // private 메서드 호출
	}
	static int total(int[] arr) {
		int total = 0;
		for (int i : arr) {
			total += i;
		}
		mystaticMethon();
		return total;
	}
	private  void myMethon() {
		System.out.println("private 메서드");
	}
	private static void mystaticMethon() {
		System.out.println("private static 메서드");
	}
}
