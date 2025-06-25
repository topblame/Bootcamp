package org.example;

public class CheckMain {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		User user1 = new User("최대호");
		
		System.out.println("출석체크");

		user1.tryCheck();
		user1.printDate();
		System.out.println("이번달출석 횟수. : "+user1.MonthCount());
	}

}
