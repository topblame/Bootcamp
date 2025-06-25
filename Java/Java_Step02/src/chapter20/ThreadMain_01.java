package chapter20;

public class ThreadMain_01 {
	public static void main(String[] args) {
		Thread_01 t = new Thread_01();
		//t.run(); //독립적인 공간 에서 실행하지만 스레드 역할을 할 수는없음.
		t.start(); //스레드는 start 메서드로 run 메서드 호출 동시실행.
		System.out.println("main 종료");
	}
}
