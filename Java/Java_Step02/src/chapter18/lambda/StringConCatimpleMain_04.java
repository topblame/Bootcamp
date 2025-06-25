package chapter18.lambda;

public class StringConCatimpleMain_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hello";
		String s2 = "World";
		
		//인스턴수 변수 -> 객체
		System.out.println("인스턴스 변수 -> 객체 ");
		StringConCatimple concat1 = new StringConCatimple();
		concat1.makeString(s1, s2);
		System.out.println();
		
		//람다식
		System.out.println("--람다식(익명의 메서드) 구현--");
		StringConcat concat2 = (s, v) ->System.out.println(s + "," + v); 
		concat2.makeString("Hello", "World");
		
		//imple 구현부
		System.out.println();
		System.out.println("--- 익명의 내부 클래스 구현 ---");
		StringConcat concat3 = new StringConcat() {
			
			@Override
			public void makeString(String s1, String s2) {
				System.out.println(s1 + " , "+ s2);
				
			}
		};
		concat3.makeString(s1, s2);
		
	}

}
