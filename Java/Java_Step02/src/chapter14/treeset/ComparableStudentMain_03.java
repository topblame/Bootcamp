package chapter14.treeset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableStudentMain_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Student> student = new ArrayList<Student>();
		
		student.add(new Student("Alice", 85));
		student.add(new Student("Bob", 85));
		student.add(new Student("Charlie", 80));
		
		
		//comparable을 사용한 정렬
		Collections.sort(student);
		
		
		System.out.println("학생들의 점수를 기준으로 오름차순 정렬");
		
		for(Student stu :student) {
			System.out.println(stu);
		}//for
	}

}
