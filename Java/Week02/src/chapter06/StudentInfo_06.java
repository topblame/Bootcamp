package chapter06;

public class StudentInfo_06 {
	//멤버 변수 = 필드 
	
	int studentID;
	private String studentName;
	int grade;
	public String address;
	
	// 생성자
	public StudentInfo_06() {
		// TODO Auto-generated constructor stub
	}
	//생성자 오버로딩

	public StudentInfo_06(int studentID, String studentName, int grade, String address) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.grade = grade;
		this.address = address;
	}

	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentName() {
		return studentName;
	}


	

}
