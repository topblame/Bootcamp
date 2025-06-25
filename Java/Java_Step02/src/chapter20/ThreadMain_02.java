package chapter20;

public class ThreadMain_02 {
	public static void main(String[] args) {
		Thread_02 t1 = new Thread_02(); //0~9까지의 요소가 저장
		
		t1.start(); //Thread1: 소요시간 10초
		
		
		//스레드가 여러개일떄는 시간차이를 두고구현
		//Thread2 병렬구조
 		try {
			Thread.sleep(11000); //11초
			System.out.println("프로그램이 종료됩니다.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}//main
}
