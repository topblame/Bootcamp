package chapter06;

import java.util.Scanner;

public class UpDownMain_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int select;
		String check;
		
		UpDown updown = new UpDown();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("숫자를 입력하세요.");
			
			select = sc.nextInt();
			check = updown.check(select);
			
			if(check.equals("SUCCESS")) {
				break;
			}//if
		}//while
		sc.close();
	}

}
