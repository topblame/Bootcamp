package chapter18.stream;

import java.util.Arrays;
import java.util.List;

public class StreamMain_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("박명수", "홍길동", "이명박", "페이커");
		//길이가 3이상인 이름을 대문자로 바꾸고 정렬 하여 출력하라.
		names.stream().filter(name-> name.length() >= 3)
		.map(String::toUpperCase)
		.sorted()
		.forEach(System.out::println);
		
	}

}
