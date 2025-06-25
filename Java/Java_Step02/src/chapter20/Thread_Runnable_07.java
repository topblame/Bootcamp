package chapter20;

public class Thread_Runnable_07	implements Runnable {
	public static void main(String[] args) {
		//일반 실행(메인스레드)
		System.out.println("메인 클래스 시작! ");
		Thread_Runnable_07 t1 = new Thread_Runnable_07();
		t1.run();
		System.out.println("----------------");
		
		Thread mThread = new Thread(t1);
		mThread.start();
		System.out.println("메인 클래스 종료! ");
	}
	//----------------
	@Override
	public void run() {
		System.out.println("run() 메서드실행 ");
		first();
	}
	public void first() {
		System.out.println("first 메서드 실행");
		second();
	}
	public void second() {
		System.out.println("second 메서드 실행");
	}
	
}
