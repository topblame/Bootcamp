package chapter07;

import java.util.Scanner;

import chapter08.A;

public class Tour {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("관광객 수: ");
		int n = Integer.parseInt(scan.nextLine());
		boolean inf = true;
		//초기화를 통해서 메모리 확보
		Guide_04 guide = new Guide_04(n);
		
		System.out.println();
		System.out.println("관광객 등록");
		//관광객 등록
		for(int i = 0; i < n; i++) {
			System.out.print((i+1)+" 이름.");
			String name = scan.nextLine();
			System.out.print((i+1)+" 성별");
			String gender = scan.nextLine();
			guide.guest[i].setName(name);
			guide.guest[i].setGender(gender);
		}
		outer : while(inf) {
			System.out.println("1 관광객 정보");
			System.out.println("2 목적지 변경");
			System.out.println("3 종료");
			System.out.print("선택 > ");
			int select = Integer.parseInt(scan.nextLine());
				switch(select) {
				case 1:	{
					for(int i = 0; i < n; i++){
						System.out.println("이름: " + guide.guest[i].getName() + " 성별 : "+guide.guest[i].getGender() + " 목적지: " + guide.point);
					}//for
					break;
				}//case 1:
				case 2:{
					System.out.print("목적지 변경");
					guide.point =scan.nextLine();
					break;
				}//case 2:
				case 3:{
					System.out.println("시스템 종료.");
					inf = false;
					break outer;
				}//case 3:
			} // switch
		}//while
	}//main 
}//class
