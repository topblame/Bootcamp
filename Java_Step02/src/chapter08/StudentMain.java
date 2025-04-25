package chapter08;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu = new Student("홍명보", "031-757-1004", 91);
		System.out.println("이름: "+stu.name+ " | 번호:  "+stu.ssn+ " | 학번 "+stu.studentNum);
	}

}
