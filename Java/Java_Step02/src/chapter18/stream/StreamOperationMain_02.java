package chapter18.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamOperationMain_02 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Sophia","Emma",
				"Olivia","Isabella","Mia");
		Stream<String> stream = list.stream();
		//중간연산 sorted() 수행후 최종연산 foreach()
		
		stream.sorted().forEach(System.out::println);
		System.out.println();
		//error : 1회 사용한 stream은 수행후 이미 소멸
		//stream.filter(s-> s.contains("M")).forEach(System.out::println);
		System.out.println("m or M이 들어간 이름 출력");
		list.stream().filter(s-> s.toUpperCase().contains("M")).forEach(System.out::println);
		
		System.out.println();
		System.out.println("이름길이가 5자 이상인 이름 출력");
		list.stream().filter(s->s.length()>=5).forEach(System.out::println);
		
		int arr[] = {39, 58, 88, 56, 77, 99 , 23};
		//오름 차순 정렬후 출력
		Arrays.stream(arr).sorted().forEach((i)-> System.out.printf(i + " "));
		System.out.println();
		System.out.println();
		
		//짝수출력 
		System.out.println("짝수 출력" );
		Arrays.stream(arr).filter((i-> i%2 == 0)).forEach((i) -> System.out.printf(i + " "));
		
		//2의 배수가 아니고 3의 배수도 아닌 숫자
		System.out.println();
		System.out.println();
		System.out.println("2의 배수가 아니고 3의 배수도 아닌 숫자" );
		Arrays.stream(arr).filter((i-> i%2 != 0 && i%3 != 0)).forEach((i) -> System.out.printf(i + " "));
	}
}
