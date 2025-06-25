package chapter12.wrapper;

import javax.swing.JOptionPane;

public class WrapperMain_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "";
		String str2 = "";
		char ch = 65; //A
		double num1, num2;
		
		//언박싱 
		num1 = Double.parseDouble(JOptionPane.showInputDialog("값1"));
		num2 = Double.parseDouble(JOptionPane.showInputDialog("값2"));
		
		if(num2 != 0) {
			System.out.println(num1/num2);
		}
		
		//isDigit : 숫자인지 아닌지.
		
		if(Character.isDigit(ch)) {
			System.out.println(ch + "는 숫자 입니다.");
		}
		else {
			System.out.println(ch + "는 숫자가 아닙니다.");
		} 
	}//main

}
