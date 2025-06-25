package chapter20;

public class ThreadMulti_05 extends Thread {

	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println(1);
		}
	}

}
