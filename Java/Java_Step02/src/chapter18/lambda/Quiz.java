package chapter18.lambda;

@FunctionalInterface
interface MyFunction{
	public int square(int a);
}
public class Quiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFunction sq = (a) -> a*a;

		System.out.println("정사각형의 넓이 각 변은 5cm : " +sq.square(5));
		
	}

}
