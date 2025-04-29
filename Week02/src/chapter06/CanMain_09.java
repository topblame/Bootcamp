package chapter06;

import java.util.Scanner;

public class CanMain_09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 0; 
		
		//음료준비
		Vending canVending = new Vending();
		canVending.init();
		
		System.out.println("돈을 투입하세요.");
		money = Integer.parseInt(sc.nextLine());
		
		canVending.showCans(money);
		
		String canName;
		System.out.println("구매할 음료를 입력해주세요.");
		canName = sc.nextLine();
		canVending.outCan(canName);
		sc.close();
	}
}
