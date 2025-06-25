package chapter20;
class Mythread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread " + Thread.currentThread().getName() + ": " + i);
			try {
				Thread.sleep(500); // 0.5초 대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class Thread_03 {
	public static void main(String[] args) {
		Mythread t1 = new Mythread();
		Mythread t2 = new Mythread();
		t1.start(); // Thread.currentThread().getName -> 스레드 고유번호.
		t2.start(); 
	}
}
