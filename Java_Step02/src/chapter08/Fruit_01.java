package chapter08;

public class Fruit_01 {
		private String sort; // 분류
		private String season; //계절과일
		
		//생성자
		
		public void Set(String a, String b) {
				sort = a;
				season = b;
		}
		
		public void Disp() {
			System.out.println("분류 : " + sort);
			System.out.println("계절 : " + season);
		}
}
