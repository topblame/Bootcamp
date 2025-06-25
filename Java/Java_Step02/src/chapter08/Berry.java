package chapter08;

//상속 키워드 extend
public class Berry extends Fruit_01{
		private String name;
		private String size;
		
		
		public void Set2(String a, String b) {
			name = a;
			size = b;
	}
	
	public void Disp2() {
		System.out.println("이름 : " + name);
		System.out.println("크기 : " + size);
	}

}
