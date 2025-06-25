package chapter18.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class lambdaMain_05 {

	public static void main(String[] args) {
		//두개의 인자를 받아서  합 리턴
		BiFunction<Integer, Integer, Integer> f1 = (x, y) -> x+y;
		System.out.println("15와 24의 합은: " + f1.apply(15, 24));
		
		BiFunction<String, String, String> f2 = (s1, s2) -> s1.concat(s2);
		System.out.println(f2.apply("람다", "식"));
		
		
		//두개의 인자를 박아서 큰수 출력
		BiConsumer<Integer, Integer> c1 = (x, y)-> System.out.println(x> y ? x: y);
		System.out.println("10과 9중 큰수 출력: ");
		c1.accept(10, 9);
		
		//매개변수(인자)로 받은 문자열과 숫자가 동일한 크기인지 판별
		BiPredicate<String, Integer> p1 = (x, y)-> x.length() == y;
		System.out.println("APPLE은 5자이다: "+ p1.test("Apple", 5));
		System.out.println("PineApple은 5자이다: " + p1.test("PineApple", 5 ));
	}

}
