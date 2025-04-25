package chapter08;

public class Student extends People{
	public int studentNum;

	public Student(String name, String ssn, int studentNum) {
		super(name, ssn); //오버로딩된 부모클래스의 생성자를 호출하여 초기화.
		this.studentNum = studentNum;
	}
	


}
