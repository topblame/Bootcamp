package soloproject;

import java.util.Scanner;

public class Menu {
	private FruitManager manager;
	private Scanner scan;
	
	public Menu() {
		manager = new FruitManager();
		scan = new Scanner(System.in);
	}
	public void run() {
		boolean running = true;
		while(running) {
			System.out.println("1. 구매, 2. 매출량 확인, 3. 종료");
            int choice;
            try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자가잘못 입력되었습니다. ");
				continue;
			}
            switch(choice) {
            case 1:
            	handlePurchase();
            	break;
            case 2:
            	manager.printSales();
            	break;
            case 3: 
            	System.out.println("시스템 종료");
            	running = false;
            	break;
            default:
            	System.out.println("없는 숫자입니다.");
            }//switch
		}//while
	}//run
	
	private void handlePurchase() {
        while (true) {
            System.out.println("구매할 탕후루 과일명 입력 (종료는 'exit')");
            System.out.println("apple, grapes, mango, melon, strawberry");
            String input = scan.nextLine().trim().toLowerCase();
            if (input.equals("exit")) break;

            boolean success = manager.purchase(input);
            if (success) {
                System.out.println(input + " 구매 완료!");
            } else {
                System.out.println("없는 과일입니다.");
            }
        }
    }
}
