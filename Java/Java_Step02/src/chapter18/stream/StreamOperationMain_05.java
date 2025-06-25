package chapter18.stream;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationMain_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] stuArr = { new Student(1, "홍길동", 85), new Student(2, "이범석", 77), new Student(3, "김홍석", 84),
				new Student(4, "최민호", 56), new Student(5, "김수정", 66), new Student(6, "최혜진", 79) };
		//Stream<Student> stream = Stream.of(stuArr).flatMap(Arrays::stream);
		
		//학생 이름만 추출 후 리스트에 저장 
		List<String> names = Stream.of(stuArr) // 스트림으로변환
				.map(Student::getName) // 이름만 추출
				.collect(Collectors.toList()); // 최종리스트로변환
		System.out.println(names);
		
		//영어 점수만가져오기 
		List<Integer> score = Stream.of(stuArr)
				.map(Student -> Student.getEng())
				.collect(Collectors.toList());
		System.out.println(score);
		
		//영어 점수만가져오기 70점이상
		List<String> score70 = Stream.of(stuArr)
				.filter(s -> s.getEng()>= 70)
				.map(Student::getName)
				.collect(Collectors.toList());
		System.out.println(score70);
	}

}
