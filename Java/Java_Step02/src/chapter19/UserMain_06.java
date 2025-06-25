package chapter19;

import java.util.Scanner;

public class UserMain_06 {

	private Scanner sc = new Scanner(System.in);
	//데이터 베이스 메서드 사용을 위한 인스턴스 생성
	private UserDAO dao = new UserDAO();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserMain_06 main = new UserMain_06();
		main.start();
		
		
	}
	
	//----------------------------------------------------------
	public void start() {
		while(true) {
			 System.out.println();
	         System.out.println("[메인메뉴] User");
	         System.out.println("------------------------------------------------------");
	         System.out.println("1. Create | 2. Read | 3. Remove | 4. Update | 5. Exit");
	         System.out.println("------------------------------------------------------");
	         System.out.print("메뉴 선택 >> ");
	         int menu = Integer.parseInt(sc.nextLine());

	         switch (menu) {
	         case 1 -> userCreate();
	         case 2 -> userRead();
	         case 3 -> userRemove();
	         case 4 -> userUpdate();
	         case 5 -> System.exit(0);
	         }
		}
	}//start

	public void userCreate() {
		 System.out.println();
	     System.out.println("[user 추가]");
	     System.out.println("==============");
	
	      // 새 user를 추가하기 위한 정보 입력받기
	     UserDTO insertDto = new UserDTO();
	     System.out.print("▶ 아이디 : ");
	     insertDto.setUserid(sc.nextLine());
	     System.out.print("▶ 비밀번호 : ");
	     insertDto.setPassword(sc.nextLine());
	     System.out.print("▶ 이메일 : ");
	     insertDto.setEmail(sc.nextLine());
	     System.out.print("▶ 이름 : ");
	     insertDto.setName(sc.nextLine());
	     System.out.print("▶ 나이 : ");
	     insertDto.setAge(Integer.parseInt(sc.nextLine()));
	     System.out.println();
	
	     int row = dao.insert(insertDto);
	     System.out.println("====================");
	
	      if (row > 0) {
	         System.out.printf("%s 님 등록완료\n", insertDto.getName());
	      } else {
	         System.out.printf("%s 님 등록실패\n", insertDto.getName());
	      }
	}
	public void userRead() {

	      System.out.print("검색할 아이디 입력 >> ");
	      String userid = sc.nextLine();

	      UserDTO user = dao.select(userid);

	      System.out.println();
	      System.out.println("조회 결과");
	      System.out.println("==============");
	      System.out.println("▶ 아이디 : " + user.getUserid());
	      System.out.println("▶ 비밀번호 : " + user.getPassword());
	      System.out.println("▶ 이메일 : " + user.getEmail());
	      System.out.println("▶ 이름 : " + user.getName());
	      System.out.println("▶ 나이 : " + user.getAge());
	}//userread
	
	public void userRemove() {
		System.out.println();
		System.out.println("[user 삭제]");
		System.out.println("==============");

		// user 정보를 삭제하기 위한 정보 입력받기
		System.out.print("▶ 아이디 : ");
		String userid = sc.nextLine();
		System.out.print("▶ 비밀번호 : ");
		String password = sc.nextLine();
		System.out.println();

		int row = dao.delete(userid, password);
		System.out.println("================================");

		if (row > 0) {
			System.out.printf("%s 삭제 완료\n", userid);
		} else {
			System.out.printf("%s 삭제 실패\n", userid);
		}
	}
	public void userUpdate() {
		System.out.println();
		System.out.println("[user 수정]");
		System.out.println("==============");

		// user 정보를 수정하기 위한 정보 입력받기
		UserDTO updateDto = new UserDTO();
		System.out.print("▶ 아이디 : ");
		updateDto.setUserid(sc.nextLine());
		System.out.print("▶ 변경 이메일 : ");
		updateDto.setEmail(sc.nextLine());
		System.out.println();

		int row = dao.update(updateDto);
		System.out.println("================================");


		if (row > 0) {
			System.out.printf("%s 로 이메일이 변경되었습니다.\n", updateDto.getEmail());
		} else {
			System.out.printf("%s 로 이메일이 변경되었습니다.\n", updateDto.getEmail());
		}
	}
}
