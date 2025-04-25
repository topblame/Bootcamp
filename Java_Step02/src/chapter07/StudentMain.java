package chapter07;

import javax.swing.JOptionPane;

public class StudentMain {
	public static void main(String[] args) {
		Student_03 studentLee = new Student_03();
		
		String name = JOptionPane.showInputDialog("이름 입력");
		studentLee.setStudentName(name);
		System.out.println("시리얼 넘버.: " + studentLee.getSerialNum() + " 이름: " + studentLee.getStudentName());

		
		System.out.println("--------------------------------");
		Student_03 studentKim = new Student_03();
		studentKim.setStudentName("김우성");
		System.out.println("시리얼 넘버.: " + studentKim.getSerialNum() + " 이름: " + studentKim.getStudentName());//10001

		
		System.out.println("--------------------------------------");
		Student_03 studentPark = new Student_03();
		studentPark.setStudentName("박정우");
		System.out.println("시리얼 넘버.: " + studentPark.getSerialNum() + " 이름: " + studentPark.getStudentName());//10001

	}
}
