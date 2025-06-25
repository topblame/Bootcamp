package chapter18.lambda;


public class AddMain_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//lambda : 메서드 이름이 없음-> 매개변수를 활용한 수행문 
 		Add addF = (x, y) -> x+y;
 		Add addF2 = (x, y) -> x*y;
 		System.out.println(addF.add(3, 5));
 		System.out.println(addF2.add(3, 5));
	}

}
