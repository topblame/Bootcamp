package chapter20;

public class ThreadMulti_06 extends Thread {
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println(2);
		}
	}

}
