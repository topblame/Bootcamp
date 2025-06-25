package chapter18.stream;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationMain_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<File> stream = Stream.of(new File("file1.txt"), new File("file2.txt"), new File("Ex2"),
				new File("Ex2.bak"), new File("Test.java"));
		//파일의 확장자를 추출 후 중복 제거 하여 출력
		stream.map(File::getName).filter(f-> f.indexOf(".") > -1)
		.map(f -> f.substring(f.lastIndexOf(".") + 1)).distinct().forEach(System.out::println);
		
		//Arrays.asList(): 배열을 스트림으로 변환
		List<String> list = Arrays.asList("Reflection", "Collection", "Stream", "Structure", "State", "Flow", "Sorting",
				"Mapping", "Reduction", "Stream");
		
		Set<String> intermediaResult = new HashSet<>();
		
		//stream연산
		List<String> result = list.stream() //스트림으로 변환
				.filter(s-> s.startsWith("S"))//s로 시작하는
				.map(String::toUpperCase) // 대문자로 변환
				.distinct()//중복제거
				.sorted() //정렬
				.peek(s -> intermediaResult.add(s)) //중간결과저장
				.collect(Collectors.toList()); //최종리스트
		System.out.println();
		System.out.println("intermediaResult Result");
		intermediaResult.forEach((i) -> System.out.println(i + " "));
		
		System.out.println();
		System.out.println("result");
		result.forEach((i)-> System.out.println(i + " "));
	}

}
