package chapter06;

public class Student_07 {
	//멤버변수
	public static final int studentID = 1000;
	public String studentName;
	int grade;
	String address;
	//기본 생성자
	public Student_07() {
		// TODO Auto-generated constructor stub
	}
	//오버로딩 생성자 student name address
	Student_07(String studentName, String address){
		this.studentName = studentName;
		this.address = address;
	}
	
	//메서드
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public static int getStudentid() {
		return studentID;
	}
	public void showStudentInfo() {
		System.out.println(studentName + ", " + address);
	}
	
}
