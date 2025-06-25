package chapter20;

public class DaemonThread_09 implements Runnable{
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		DaemonThread_09 dm = new DaemonThread_09();
		Thread t = new Thread(dm); //run ()을 start()로 변환 
		//데몬 스레든는 메인스레드가 종료되면 자동 종료됨.
		t.setDaemon(true); //데몬 스레드
		t.start(); //데몬스레드 실행
		
		for(int i = 0; i< 15; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(i); //메인
			if(i == 3) {
				autoSave = true;
			}
		}
	}
	
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000); // 3초
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(autoSave) {
				System.out.println("자동저장 됩니다. ");
			}
			
		}//while
	}
}
