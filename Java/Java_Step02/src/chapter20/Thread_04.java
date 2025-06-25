package chapter20;
class Counter{
	private int count = 0;
	
	synchronized void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}

	
}
public class Thread_04 {
	public static void main(String[] args) {
		Counter counter = new Counter();
		
		Runnable task = ()->{
			for (int i=0; i<1000; i++) {
				counter.increment();
			}
		}; //runnable
		
		
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		
		//스레드가 동시에 실행되어도 충돌없이 컴파일딤.
		t1.start();
		t2.start();
		try {
			t1.join(); // 스레드 작업이 끝날떄까지 기다림 .
			t2.join(); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(counter.getCount());
	}
}
