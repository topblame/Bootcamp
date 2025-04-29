package chapter06;

public class Student_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//기본 생성자 stu1
		Student_07 stu1 = new Student_07();
		
		stu1.address = "서울 성북구";
		stu1.grade = 4;
		stu1.studentName = "최대호";
		
		stu1.showStudentInfo();
		
		System.out.println();
		
		Student_07 stu2 = new Student_07("최대호", "서울 성북구");
		stu2.showStudentInfo();
		
		//getter / setter
		Student_07 stu3 = new Student_07();
		stu3.setStudentName("솔데스크");
		stu3.setAddress("성북구");
		System.out.println(stu3.getStudentName());
		System.out.println(stu3.getAddress());
		
		
		
	}

}
