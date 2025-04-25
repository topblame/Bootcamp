package chapter07;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class BankMain {
	public static void main(String[] args) {
		//일산점. 전화번호 031-123-5678 이자율 5.3f
		//종로점. 02-852-9856
		
		Bank_02 ilsan = new Bank_02("일산", "031-123-5678");
		Bank_02 jongro = new Bank_02("종로", "02-852-9856");
		
		String point = JOptionPane.showInputDialog("지점명");
		String tel = JOptionPane.showInputDialog("전화번호");
		
		Bank_02 bank = new Bank_02(point, tel);
		Scanner sc = new Scanner(System.in);
		System.out.print(point + "지점의 퇴직연금의 이자를 입력하세요. ");
		Bank_02.interest = sc.nextFloat();
		bank.getBank();
		System.out.println("종로지점의 퇴직연금의 이자" + jongro.interest);
	}
}
