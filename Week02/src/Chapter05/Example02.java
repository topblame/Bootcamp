package Chapter05;

import javax.swing.JOptionPane;

public class Example02 {
	public static int sum(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	public static void total(int num1, int num2) {
		System.out.println("두 수의 합 : " + (num1+num2));
	}
	
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int num1 = 10;
		int num2 = 20;
		int result = sum(num1, num2);
		System.out.println("반환값 출력: "+ result);
		
		//
		total(num1, num2);
	}

}
