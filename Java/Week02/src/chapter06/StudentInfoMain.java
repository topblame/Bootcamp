package chapter06;

public class StudentInfoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentInfo_06 stu = new StudentInfo_06(1971383, "최대호", 4, "성남시");
	
		System.out.println("주소 " + stu.address);
		System.out.println("이름: " + stu.getStudentName());
	
		//기본생성자를 이용해서 객체 생성 (student kim)
		StudentInfo_06 student = new StudentInfo_06();
		
		//주소를 직관적으로 초기화 하고 출력.
		student.address = "성남시 중원구";
		student.studentID = 197;
		student.grade = 4;
		student.setStudentName("최대호");
		
		System.out.println("이름 " + student.getStudentName());
		System.out.println("주소: " + student.address);
		System.out.println("학년: " + student.grade);
		System.out.println("학번: " + student.studentID);
		
		//기본생성자를 이용해서 객체 생성(studentlee)
		StudentInfo_06 studentlee = new StudentInfo_06();
		//getters /setters
		studentlee.setStudentName("나세종");
		System.out.println(studentlee.getStudentName());
	}

}
