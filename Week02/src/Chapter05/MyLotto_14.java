package Chapter05;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class MyLotto_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Scan = new Scanner(System.in);
		int cnt = 0;
		System.out.println("");
		int num = Integer.parseInt(Scan.nextLine());
		while(num > cnt) {
			System.out.println("[" + (cnt + 1) + "]:");
			int[] lotto = new int[6];
			int index = 0;
			
			while(index < 6) {
				int num1 = (int)(Math.random()*45) + 1 ;
				if(!contains(lotto, num1)) {//중복체크
					lotto[index++] = num1;
				}//if
			}//while
		
			for(int num1:lotto) {
				System.out.print(num + " ");
			}
			System.out.println();
			cnt++;
		}//while
	}
	// ````````````````````````````````````
	// 중복 체크 검수하는 메소드
	public static boolean contains(int[] arr, int num) {
		for (int i : arr) {
			if(i == num) {// 배열방에 있는 숫자 == 방금 받은 숫자
				return true;//중복 발견
			}//if
		}// for
		return false; // 중복값 없ㅇ므.
	}//contains
}
