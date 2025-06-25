package chapter06;

import java.util.Random;

public class UpDown {
//	private int checknum = (int)(Math.random()*50);
	private int checknum = new Random().nextInt(50)+ 1;
	private int count;
	private String result = "FALSE";
	public String check(int select) {
		count++;
		if(select < checknum) {
			System.out.println("up");
		}
		else if(select > checknum) {
			System.out.println("down");
		}
		else if(select == checknum) {
			System.out.println(count +"안에 정답! SUCCESS");
			return "SUCCESS";
		}
		else {
			System.out.println("error");
		}
		return result;
		
	}
}
